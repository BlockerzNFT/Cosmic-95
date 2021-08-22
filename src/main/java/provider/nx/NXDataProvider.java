package provider.nx;

import nx.LazyNXFile;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NXDataProvider implements MapleDataProvider {

    private final static Map<Path, NXDataProvider> openedFiles = new ConcurrentHashMap<>();

    private final LazyNXFile nxfile;
    private final NXData rootData;

    private NXDataProvider(Path path) throws IOException {
        nxfile = new LazyNXFile(path);
        rootData = new NXData(nxfile.getRoot());
    }

    /**
     * If an {@code NXDataProvider} for the given {@code path} does not
     * already exist, this creates one. Otherwise, the existing provider
     * is returned.
     *
     * @param path A path either absolute, or relative to the NX directory.
     * @return An {@code NXDataProvider} serving the given path.
     */
    public static NXDataProvider openFile(String path) throws IOException {
        return openFile(MapleDataProviderFactory.resolvePath(Paths.get(path)));
    }

    /**
     * If an {@code NXDataProvider} for the given {@code path} does not
     * already exist, this creates one. Otherwise, the existing provider
     * is returned.
     *
     * @param path An absolute path.
     * @return An {@code NXDataProvider} serving the given path.
     * @throws IllegalArgumentException Thrown if the given path is not absolute.
     */
    public static NXDataProvider openFile(Path path) throws IOException {
        if (!path.isAbsolute()) {
            throw new IllegalArgumentException("Given path must be absolute.");
        }

        NXDataProvider ret = openedFiles.get(path);
        if (ret == null) {
            ret = new NXDataProvider(path);
            openedFiles.put(path, ret);
            return ret;
        }
        return ret;
    }

    public MapleData getData(String path) {
        if (path.equals("/")) {
            return getRoot();
        }
        return new NXData(nxfile.resolve(path.startsWith("/") ? path.substring(1) : path));
    }

    public MapleData getRoot() {
        return rootData;
    }

}
