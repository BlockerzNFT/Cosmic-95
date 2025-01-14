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

import provider.MapleDataType;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapleDataTool {
    public static String getString(MapleData data) {
        return (String) data.getData();
    }

    public static String getString(MapleData data, String def) {
        if (data == null) {
            return def;
        }
        try {
            return getString(data);
        } catch (Exception e) {
            return def;
        }
    }

    public static String getString(String path, MapleData data) {
        return getString(data.getChildByPath(path));
    }

    public static String getString(String path, MapleData data, String def) {
        return getString(data.getChildByPath(path), def);
    }

    public static double getDouble(MapleData data) {
        return (Double) data.getData();
    }

    public static double getDouble(MapleData data, double def) {
        if (data == null) {
            return def;
        }
        try {
            return getDouble(data);
        } catch (Exception e) {
            return def;
        }
    }

    public static float toFloat(MapleData data, float def) {
        if (data == null) {
            return def;
        }
        try {
            return getFloat(data);
        } catch (Exception e) {
            return def;
        }
    }

    public static float getFloat(MapleData data) {
        Object ret = data.getData();
        if (ret instanceof Double) {
            return ((Double) ret).floatValue();
        } else {
            return (Float) ret;
        }
    }
    public static int getInt(MapleData data) {
        Object ret = data.getData();
        if (ret instanceof Long) {
            return ((Long) ret).intValue();
        } else if (ret instanceof String) {
            return Integer.parseInt((String) ret);
        } else {
            return (Integer) ret;
        }
    }

    public static int getInt(String path, MapleData data) {
        return getInt(data.getChildByPath(path));
    }

    public static int getIntConvert(MapleData data) {
        if (data.getType() == MapleDataType.STRING) {
            return Integer.parseInt(getString(data));
        } else {
            return getInt(data);
        }
    }
    
    public static int getIntConvert(MapleData data, int def) {
        if (data == null) {
            return def;
        }
        if (data.getType() == MapleDataType.STRING) {
	    String dd = getString(data);
	    if (dd.endsWith("%")) {
		dd = dd.substring(0, dd.length() - 1);
	    }
            try {
                return Integer.parseInt(dd);
            } catch (NumberFormatException nfe) {
                return def;
            }
        } else {
            return getInt(data, def);
        }
    }

    public static int getIntConvert(String path, MapleData data) {
        MapleData d = data.getChildByPath(path);
        if (d.getType() == MapleDataType.STRING) {
            return Integer.parseInt(getString(d));
        } else {
            return getInt(d);
        }
    }

    public static int getInt(MapleData data, int def) {
        if (data == null) {
            return def;
        }
        try {
            return toInt(data);
        } catch (Exception e) {
            return def;
        }
    }

    public static int toInt(MapleData data) {
        Object ret = data.getData();
        if (ret instanceof Long) {
            return ((Long) ret).intValue();
        } else if (ret instanceof String) {
            return Integer.parseInt((String) ret);
        } else {
            return (Integer) ret;
        }
    }

    public static int getInt(String path, MapleData data, int def) {
        return getInt(data.getChildByPath(path), def);
    }

    public static int getIntConvert(String path, MapleData data, int def) {
        MapleData d = data.getChildByPath(path);
        if (d == null) {
            return def;
        }
        if (d.getType() == MapleDataType.STRING) {
            try {
                return Integer.parseInt(getString(d));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                return def;
            }
        } else {
            return getInt(d, def);
        }
    }

    public static BufferedImage getImage(MapleData data) {
        return ((MapleCanvas) data.getData()).getImage();
    }

    public static Point getPoint(MapleData data) {
        return ((Point) data.getData());
    }

    public static Point getPoint(String path, MapleData data) {
        return getPoint(data.getChildByPath(path));
    }

    public static Point getPoint(String path, MapleData data, Point def) {
        final MapleData pointData = data.getChildByPath(path);
        if (pointData == null) {
            return def;
        }
        return getPoint(pointData);
    }

    public static String getFullDataPath(MapleData data) {
        String path = "";
        MapleDataEntity myData = data;
        while (myData != null) {
            path = myData.getName() + "/" + path;
            myData = myData.getParent();
        }
        return path.substring(0, path.length() - 1);
    }
}
