package provider.nx;

import nx.NXNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import provider.MapleData;
import provider.MapleDataEntity;
import provider.MapleDataType;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class NXData implements MapleData {

    private static final Pattern SLASH_REGEX = Pattern.compile("/");
    private final NXNode nxNode;


    NXData(NXNode nxNode) {
        this.nxNode = nxNode;
    }

    private static NXData nullOrData(NXNode n) {
        return n == null ? null : new NXData(n);
    }

    @Override
    public String getName() {
        return nxNode.getName();
    }

    @Override
    public MapleDataEntity getParent() {
        return null;
    }

    @Override
    public MapleDataType getType() {
        return null;
    }

    public List<MapleData> getChildren() {
        List<MapleData> ret = new ArrayList<>();
        return ret;
    }

    @Override
    public MapleData getChildByPath(String name) {
        return nullOrData(nxNode.getChild(name));
    }

    @Override
    public MapleData resolve(String rawPath) {
        String[] path = SLASH_REGEX.split((rawPath.startsWith("/") ? rawPath.substring(1) : rawPath));
        NXNode cursor = nxNode;
        for (String aPath : path) {
            if (cursor == null) {
                break;
            }
            cursor = cursor.getChild(aPath);
        }
        return nullOrData(cursor);
    }

    @Override
    public Object getData() {
        return nxNode.get();
    }

    @Override
    public Iterator<MapleData> iterator() {
        return new NXDataIterator(nxNode.iterator());
    }

    private static class NXDataIterator implements Iterator<MapleData> {

        private final Iterator<NXNode> nxNodeIter;

        NXDataIterator(Iterator<NXNode> nxNodeIter) {
            this.nxNodeIter = nxNodeIter;
        }

        @Override
        public boolean hasNext() {
            return nxNodeIter.hasNext();
        }

        @Override
        public MapleData next() {
            return new NXData(nxNodeIter.next());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
