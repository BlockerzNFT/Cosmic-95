var item;
var stance;
var status = -1;
var item;

function end(mode, type, selection) {
	if(mode == 0) {
		qm.dispose();
		return;
	}
        status++;

	if(status == 0) {
		qm.sendNext("What the? Are you telling me you've already taken out 150 #o4230120#s? And these ... yes, these really are 120 #t4000122#s. I was wondering how you were going to complete this mission all by yourself, but you took care of it just fine. Alright, here ... this is a very important item for me, but please take it.");
	} else if(status == 1) {
	    const MapleInventoryType = Java.type('client.inventory.MapleInventoryType');
	    if(qm.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() < 1) {
		qm.sendOk("Please free a EQUIP inventory slot to receive the reward.");
		qm.dispose();
		return;
	    }

            var talkStr = "Do you like the glove? I've kept this for a while, and I was planning on using it someday, but it looks much better on you. Please put it to good use; besides, I got so much stuff from the Sector, that I don't need it anymore.";
            stance = qm.getPlayer().getJobStyle();
            
            const MapleJob = Java.type('client.MapleJob');
            if(stance == MapleJob.WARRIOR) item = 1082024;
            else if(stance == MapleJob.MAGICIAN) item = 1082063;
            else if(stance == MapleJob.BOWMAN || stance == MapleJob.CROSSBOWMAN) item = 1082072;
            else if(stance == MapleJob.THIEF) item = 1082076;
            else if(stance == MapleJob.BRAWLER || stance == MapleJob.GUNSLINGER) item = 1082195;
            else item = 1082149;
            
            qm.sendNext(talkStr);
	} else if(status == 2) {
            qm.completeQuest();
            qm.gainItem(item, 1);
            qm.gainItem(4000122, -120);
            qm.gainExp(6100);
            qm.sendOk("Thank you so much for fulfilling your missions as one of the Mesorangers. I've told the Sector about your successful story, and the Sector seems to be very pleased with you, too. Hopefully you'll keep working with us. Bye~");
        } else if (status == 3) {
            qm.dispose();
        }
}