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
package net.opcodes;

public enum RecvOpcode {
    CUSTOM_PACKET(0x3713),//13 37 lol
    
    LOGIN_PASSWORD(0x01), //95
    GUEST_LOGIN(0x02), //95
    SERVERLIST_REREQUEST(0x04), //95
    CHARLIST_REQUEST(0x05), //95
    SERVERSTATUS_REQUEST(0x06), //95
    ACCEPT_TOS(0x07), //95
    SET_GENDER(0x08), //95
    AFTER_LOGIN(0x09), //95
    REGISTER_PIN(0x0A), //95
    SERVERLIST_REQUEST(0x0B), //95
    PLAYER_DC(0x0C), //95
    VIEW_ALL_CHAR(0x0D), //95
    PICK_ALL_CHAR(0x0E), //95
    NAME_TRANSFER(0x10), //95
    WORLD_TRANSFER(0x12), //95
    CHAR_SELECT(0x13), //95
    PLAYER_LOGGEDIN(0x14), //95
    CHECK_CHAR_NAME(0x15), //95
    CREATE_CHAR(0x16), //95
    CREATE_CHAR_IN_CS(0x17), //95
    DELETE_CHAR(0x18), //95
    PONG(0x19), //95
    CLIENT_START_ERROR(0x19), //95
    CLIENT_ERROR(0x24), //95
    STRANGE_DATA(0x1B),
    RELOG(0x1C),
    REGISTER_PIC(0x1D),
    CHAR_SELECT_WITH_PIC(0x1E),
    VIEW_ALL_PIC_REGISTER(0x1F),
    VIEW_ALL_WITH_PIC(0x20),
    CHANGE_MAP(0x29), // 95
    CHANGE_CHANNEL(0x2A), // 95
    ENTER_CASHSHOP(0x2B), // 95
    MOVE_PLAYER(0x2C),
    CANCEL_CHAIR(0x2A),
    USE_CHAIR(0x2D), // 95
    CLOSE_RANGE_ATTACK(0x2F),
    RANGED_ATTACK(0x30),
    MAGIC_ATTACK(0x31),
    TOUCH_MONSTER_ATTACK(0x2F),
    TAKE_DAMAGE(0x34), //95
    GENERAL_CHAT(0x36), //95
    CLOSE_CHALKBOARD(0x37), //v95
    FACE_EXPRESSION(0x38), // v95
    USE_ITEMEFFECT(0x39), // v95
    USE_DEATHITEM(0x35),
    MOB_BANISH_PLAYER(0x38),
    MONSTER_BOOK_COVER(0x39),
    NPC_TALK(0x3F), // v95
    REMOTE_STORE(0x3B),
    NPC_TALK_MORE(0xF1),
    NPC_SHOP(0x3D),
    STORAGE(0x3E),
    HIRED_MERCHANT_REQUEST(0x3F),
    FREDRICK_ACTION(0x40),
    DUEY_ACTION(0x41),
    OWL_ACTION(0x42),   //sends most searched info to client
    OWL_WARP(0x43),     //handles player warp to store
    ADMIN_SHOP(0x44),
    ITEM_SORT(0x45),
    ITEM_SORT2(0x46),
    ITEM_MOVE(0x47),
    USE_ITEM(0x48),
    CANCEL_ITEM_EFFECT(0x49),
    USE_SUMMON_BAG(0x4B),
    PET_FOOD(0x4C),
    USE_MOUNT_FOOD(0x4D),
    SCRIPTED_ITEM(0x4E),
    USE_CASH_ITEM(0x4F),
    //USE_OWL_ITEM(0x50), ... no idea
    USE_CATCH_ITEM(0x51),
    USE_SKILL_BOOK(0x52),
    USE_TELEPORT_ROCK(0x54),
    USE_RETURN_SCROLL(0x55),
    USE_UPGRADE_SCROLL(0x56),
    DISTRIBUTE_AP(0x62), // 95
    AUTO_DISTRIBUTE_AP(0x63), //95
    HEAL_OVER_TIME(0x64), // 95
    DISTRIBUTE_SP(0x66), //95
    SPECIAL_MOVE(0x67), // 95
    CANCEL_BUFF(0x5C),
    SKILL_EFFECT(0x5D),
    MESO_DROP(0x6A), //95
    GIVE_FAME(0x6B), //95
    CHAR_INFO_REQUEST(0x61),
    SPAWN_PET(0xC6),
    CANCEL_DEBUFF(0x63),
    CHANGE_MAP_SPECIAL(-1), // TODO figure out
    USE_INNER_PORTAL(0x65),
    TROCK_ADD_MAP(-1),
    REPORT(0x6A),
    QUEST_ACTION(0x6B),
    //USER_CALC_DAMAGE_STAT_SET_REQUEST(0x6C),
    GRENADE_EFFECT(0x6D),
    SKILL_MACRO(0x6E),
    USE_ITEM_REWARD(0x70),
    MAKER_SKILL(0x71),
    USE_REMOTE(0x74),
    WATER_OF_LIFE(0x75),
    ADMIN_CHAT(0x76),
    MULTI_CHAT(0x77),
    WHISPER(0x78),
    SPOUSE_CHAT(0x79),
    MESSENGER(0x7A),
    PLAYER_INTERACTION(0x7B),
    PARTY_OPERATION(0x7C),
    DENY_PARTY_REQUEST(0x7D),
    GUILD_OPERATION(0x7E),
    DENY_GUILD_REQUEST(0x7F),
    ADMIN_COMMAND(0x80),
    ADMIN_LOG(0x81),
    BUDDYLIST_MODIFY(0x82),
    NOTE_ACTION(0x83),
    USE_DOOR(0x85),
    CHANGE_KEYMAP(0x9F), // v95
    RPS_ACTION(0x88),
    RING_ACTION(0x89),
    WEDDING_ACTION(0x8A),
    WEDDING_TALK(0x8B),
    WEDDING_TALK_MORE(0x8B),
    ALLIANCE_OPERATION(0x8F),
    DENY_ALLIANCE_REQUEST(0x90),
    OPEN_FAMILY_PEDIGREE(0x91),
    OPEN_FAMILY(0x92),
    ADD_FAMILY(0x93),
    SEPARATE_FAMILY_BY_SENIOR(0x94),
    SEPARATE_FAMILY_BY_JUNIOR(0x95),
    ACCEPT_FAMILY(0x96),
    USE_FAMILY(0x97),
    CHANGE_FAMILY_MESSAGE(0x98),
    FAMILY_SUMMON_RESPONSE(0x99),
    BBS_OPERATION(0x9B),
    ENTER_MTS(0x9C),
    USE_SOLOMON_ITEM(0x9D),
    USE_GACHA_EXP(0x9E),
    NEW_YEAR_CARD_REQUEST(0xB7), // v95
    CASHSHOP_SURPRISE(0xA1),
    CLICK_GUIDE(0xA2),
    ARAN_COMBO_COUNTER(0xA3),
    MOVE_PET(0xA7),
    PET_CHAT(0xA8),
    PET_COMMAND(0xA9),
    PET_LOOT(0xAA),
    PET_AUTO_POT(0xAB),
    PET_EXCLUDE_ITEMS(0xAC),
    MOVE_SUMMON(0xAF),
    SUMMON_ATTACK(0xB0),
    DAMAGE_SUMMON(0xB1),
    BEHOLDER(0xB2),
    MOVE_DRAGON(0xB5),
    CHANGE_QUICKSLOT(0xB7),//CP_QuickslotKeyMappedModified
    MOVE_LIFE(0xBC),
    AUTO_AGGRO(0xBD),
    FIELD_DAMAGE_MOB(0xBF),
    MOB_DAMAGE_MOB_FRIENDLY(0xC0),
    MONSTER_BOMB(0xC1),
    MOB_DAMAGE_MOB(0xC2),
    NPC_ACTION(0xC5),
    ITEM_PICKUP(0xCA),
    DAMAGE_REACTOR(0xCD),
    TOUCHING_REACTOR(0xCE),
    PLAYER_MAP_TRANSFER(0xCF),
    MAPLETV(0xFFFE),//Don't know
    SNOWBALL(0xD3),
    LEFT_KNOCKBACK(0xD4),
    COCONUT(0xD5),
    MATCH_TABLE(0xD6),//Would be cool if I ever get it to work :)
    MONSTER_CARNIVAL(0x106), //95
    PARTY_SEARCH_REGISTER(0xDC),
    PARTY_SEARCH_START(0xDE),
    PARTY_SEARCH_UPDATE(0xDF),
    CHECK_CASH(0xE4),
    CASHSHOP_OPERATION(0xE5),
    COUPON_CODE(0xE6),
    OPEN_ITEMUI(0xEC),
    CLOSE_ITEMUI(0xED),
    USE_ITEMUI(0xEE),
    MTS_OPERATION(0xFD),
    USE_MAPLELIFE(0x100),
    USE_HAMMER(0x104);
    
    private int code = -2;

    private RecvOpcode(int code) {
        this.code = code;
    }

    public int getValue() {
        return code;
    }
}
