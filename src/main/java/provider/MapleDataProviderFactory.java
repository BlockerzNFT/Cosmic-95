/*
	This file is part of the OdinMS Maple Story Server
    Copyright (C) 2008 Patrick Huy <patrick.huy@frz.cc>
		       Matthias Butz <matze@odinms.de>
		       Jan Christian Meyer <vimes@odinms.de>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package provider;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import provider.nx.NXDataProvider;
import provider.wz.WZFiles;

public class MapleDataProviderFactory {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MapleDataProviderFactory.class);
    private final static Path nxPath = Paths.get(System.getProperty("user.dir")+"/nx").toAbsolutePath();

    public static MapleDataProvider getDataProvider(WZFiles wzName) {
        try {
            String name = wzName.toString();
            return NXDataProvider.openFile(name.concat(".nx"));
        } catch (IOException ioe) {
            log.error("Failed to open NX file.", ioe);
        }
        return null;
    }

    public static Path resolvePath(Path relative) {
        return nxPath.resolve(relative);
    }
}