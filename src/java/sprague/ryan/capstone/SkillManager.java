package sprague.ryan.capstone;

import java.util.ArrayList;

/**
 * @author Ryan Sprague
 */
public class SkillManager {
    private ArrayList<Skill> skills = new ArrayList<>();
    
    public SkillManager() {
        // barbarian skills
        skills.add(new Skill("Rage", null, "Advantage on Strenght chcks and Strenght saving throws;" + 
                " bonus melee damage; resistance to bludgeoning, piercing, and slashing damage", "barbarian", 1 ));
        skills.add(new Skill("Unarmored Defense", null, "Without armor, armor class = 10 + dexterity modifier + constitution modifier.", "barbarian", 1));
        skills.add(new Skill("Reckless Attack", null, "Can use on first attack, gives you advantage for strength rolls in same turn, but rolls against you" +
                " have advantage until next turn", "barbarian", 2));
        skills.add(new Skill("Danger Sense", null, "You have advantage on dexterity saving throws against effects you can see.  Must not be" +
                " blinded, deafened, or incapacitated to take effect.", "barbarian", 2));
        skills.add(new Skill("Frenzy", "Berserker Path", "get a bonus attack when you rage.  Suffere one level of exhaustion at end of rage.",
                "barbarian", 3));
        skills. add(new Skill("Extra Attack", null, "can attack twice for attack action on your turn", "barbarian", 5));
        skills.add(new Skill("Fast Movement", null, "your speed increases by 10 feet when you aren't wearing heavy armor", "barbarian", 5));
        skills.add(new Skill("Mindless Rage", "Berserker Path", "can't be charmed or frightened while raging." + 
                " If you are charmed or frightened when you rage, effect is suspended until end of rage.", "barbarian", 6));
        skills.add(new Skill("Feral Instinct", null, "advantage on initiative rolls. If surprised at beginning of combat, no disadvantage as long as" +
                " you go into a rage before anything else.", "barbarian", 7));
        skills.add(new Skill("Brutal Critical", null, "roll on additional weapon damage die when" +
                " determining the extra damage for a crit hit with a melee attack.", "barbarian", 9));
        skills.add(new Skill("Intimidating Presence", "Berserker Path", "can use your action to frighten someone.  Choose one creature" + 
                " that you can see within 30 feet of you.  If the creature can see or hear you, it must succeed on a wisdom saving throw (DC " +
                "equal to 8 + your proficiency bonus + your Charisma modifier) or be frightened until the end of your next turn.  On subsequent" +
                " turns, you can use your action to extend the duration of the effect until the end of your next turn.  Effect ends if the" +
                " creature ends its turn out of line of sight or more than 60 feet away from you.  If the creature succeeds on its saving throw," +
                " you can't use this feature on that creature again for 24 hours.", "barbarian", 10));
        skills.add(new Skill("Relentless Rage", null, "If you drop to 0 hp while raging and don't die outright," +
                " you can make a DC 10 constitution saving throw.  If you succeed, you drop to 1 hp instead.", "barbarian", 11));
        skills.add(new Skill("Brutal Critical 2", null, "roll on additional weapon damage die when" +
                " determining the extra damage for a crit hit with a melee attack.", "barbarian", 13));
        skills.add(new Skill("Retaliation", "Berserker Path", "When you take damage from a creature within 5 feet of you" +
                " you can use your reaction to make a melee weapon attack against the creature.", "barbarian", 14));
        skills.add(new Skill("Persistent Rage", null, "Your rage ends early only if you fall unconscioius or if you choose to end it.", "barbarian", 15));
        skills.add(new Skill("Brutal Critical 3", null, "roll on additional weapon damage die when" +
                " determining the extra damage for a crit hit with a melee attack.", "barbarian", 17));
        skills.add(new Skill("Indomitable Might", null, "If your total for a Strength Check is less than your Strength score, you can use that" +
                " score in place of the total.", "barbarian", 18));
        skills.add(new Skill("Primal Champion", null, "Your strength and Constitution scores increase by 4." +
                "  Your maximum for those scores is now 24.", "barbarian", 20));
        
        // bard skills
        skills.add(new Skill("Spellcasting", null, "You have learned to untangle and reshape the fabric of reality in harmony with your" +
                " wishes and music.  Your spells are part of your vast repertoire, magic that you can tune to different situations." +
                " You know two cantrips of your choice from the bard spell list. You learn additional bard cantrips at higher levels." +
                " You can cast any bard spell you know as a ritual if that spell has the ritual tag.  You can use a muscial instrument" +
                " as a spellcasting focus for your bard spells.", "bard", 1));
        skills.add(new Skill("Bardic Inspiration", null, "You can inspire others through stirring words or music.  To do so, you use a bonus" +
                " action on your turn to choose one creature other than yourself within 60 feet of you who can hear you.  That" +
                " creature gains one Bardic Inspiration die, a d6.  Once within the next 10 minutes, the creature can roll the die" +
                " and add the number rolled to one ability check, attack roll, or saving throw it makes.  The creature can wait" +
                " until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says" +
                " whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost.  A creature can have only" +
                " Bardic Inspiration die at a time.  You can use this feature a number of times equal to your Charisma modifier" +
                " (minimum of once).  You regain any expended uses when you finish a long rest.  Your Bardic Inspiration die changes" +
                " when you reach certain levels.  The die becomes a d8 at 5th level, a d10 at 10th level, and a d12 at 15th level.",
                "bard", 1));
        skills.add(new Skill("Jack of All Trades", null, "You can add half your proficiency bonus, rounded down, to any ability check" +
                " you make that doesn't already include your proficiency bonus.", "bard", 2));
        skills.add(new Skill("Song of Rest", null, "You can use soothing music or oration to help revitalize your wounded allies during" +
                " a short rest.  If you or any friendly creatures who can hear your performance regain hit points at the end of the" +
                " short rest by spending one or more Hit Dice, each of those creatures regains an extra 1d6 hit points." +
                "  The extra hit points increase when you reach certain levels in this class: to 1d8 at 9th level, to 1d10 at" +
                " 13th level, and to 1d12 at 17th level.", "bard", 2));
        skills.add(new Skill("Cutting Words", "College of Lore", "You learn how to use your wit to distract, confuse, and otherwise" +
                " sap the confidence and competence of otehrs.  When a creature that you can see within 60 feet of you makes an" +
                " attack roll, an ability check, or a damage roll, you can use your reaction to expend one of your uses of Bardic" +
                " Inspiration, rolling a Bardic Inspiration die and subtracting the number rolled from the creature's roll." +
                "  You can choose to use this feature after the creature makes its roll, but before the DM determines whether" +
                " the attack roll or ability check succeeds or fails, or before the creature deals its damage." +
                "  The creature is immune if it can't hear you or if it's immune to being charmed.", "bard", 3));
        skills.add(new Skill("Expertise", null, "Choose two of your skill proficiencies.  Your proficiency bonus is doubled for any" +
                " ability check you make that uses either of the chosen proficiencies.  At 10th level, you can choose another two" +
                " skill proficiencies to gain this benefit.", "bard", 3));
        skills.add(new Skill("Bardic Inspiration 2", null, "You can inspire others through stirring words or music.  To do so, you use a bonus" +
                " action on your turn to choose one creature other than yourself within 60 feet of you who can hear you.  That" +
                " creature gains one Bardic Inspiration die, a d8.  Once within the next 10 minutes, the creature can roll the die" +
                " and add the number rolled to one ability check, attack roll, or saving throw it makes.  The creature can wait" +
                " until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says" +
                " whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost.  A creature can have only" +
                " Bardic Inspiration die at a time.  You can use this feature a number of times equal to your Charisma modifier" +
                " (minimum of once).  You regain any expended uses when you finish a long rest.  Your Bardic Inspiration die changes" +
                " when you reach certain levels.  The die becomes a d10 at 10th level, and a d12 at 15th level.", "bard", 5));
        skills.add(new Skill("Font of Inspiration", null, "You regain all of your expended uses of Bardic Inspiration when you finish a" +
                " short or long rest.", "bard", 5));
        skills.add(new Skill("Additional Magical Secrets", "College of Lore", "You learn two spells of your choice from any" +
                " class.  A spell you choose must be of a level you can cast, as shown on the badr table, or a cantrip.  The" +
                " chosen spells count as bard spells for you but don't count against the number of bard spells you know.", "bard", 6));
        skills.add(new Skill("Countercharm", null, "You gain the ability to use musical notes or words of power to disrupt" +
                " mind-influencing effects.  As an action, you can start a performance that lasts until the end of your" +
                " next turn.  During that time, you and any friendly creatures within 30 feet of you have advantage on saving" +
                " throws against being frightened or charmed.  A creature must be able to hear you to gain this benefit." +
                "  The performance ends early if you are incapacitated or silenced or if you voluntarily end it (no action" +
                " required).", "bard", 6));
        skills.add(new Skill("Song of Rest 2", null, "You can use soothing music or oration to help revitalize your wounded allies during" +
                " a short rest.  If you or any friendly creatures who can hear your performance regain hit points at the end of the" +
                " short rest by spending one or more Hit Dice, each of those creatures regains an extra 1d8 hit points." +
                "  The extra hit points increase to 1d10 at" +
                " 13th level, and to 1d12 at 17th level.", "bard", 9));
        skills.add(new Skill("Bardic Inspiration 3", null, "You can inspire others through stirring words or music.  To do so, you use a bonus" +
                " action on your turn to choose one creature other than yourself within 60 feet of you who can hear you.  That" +
                " creature gains one Bardic Inspiration die, a d10.  Once within the next 10 minutes, the creature can roll the die" +
                " and add the number rolled to one ability check, attack roll, or saving throw it makes.  The creature can wait" +
                " until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says" +
                " whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost.  A creature can have only" +
                " Bardic Inspiration die at a time.  You can use this feature a number of times equal to your Charisma modifier" +
                " (minimum of once).  You regain any expended uses when you finish a long rest.  Your Bardic Inspiration die changes" +
                " when you reach certain levels.  The die becomes a d12 at 15th level.", "bard", 10));
        skills.add(new Skill("Expertise 2", null, "Choose an additional two of your skill proficiencies.  Your proficiency bonus is" +
                " doubled for any ability check you make that uses either of the chosen proficiencies.", "bard", 10));
        skills.add(new Skill("Magical Secrets", null, "You have plundered magical knowledge from a wide spectrum of disciplines." +
                "  Choose two spells from any class, including this one.  A spell you choose must be of a level you can cast," +
                " as shown on the Bard table, or a cantrip.  The chosen spells count as bard spells count as bard spells for" +
                " you and are included in the number in the Spells Known column of the Bard table.  You learn two additional" +
                " spells from any class at 14th level, and again at 18th level.", "bard", 10));
        skills.add(new Skill("Song of Rest 3", null, "You can use soothing music or oration to help revitalize your wounded allies during" +
                " a short rest.  If you or any friendly creatures who can hear your performance regain hit points at the end of the" +
                " short rest by spending one or more Hit Dice, each of those creatures regains an extra 1d10 hit points." +
                "  The extra hit points increase to 1d12 at 17th level.", "bard", 13));
        skills.add(new Skill("Magical Secrets 2", null, "Choose another two spells from any class, including this one. A spell" +
                " you choose must be of a level you can cast, as shown on the Bard table, or a cantrip.  The chosen spells" +
                " count as bard spells count as bard spells for you and are included in the number in the Spells Known" +
                " column of the Bard table.  You learn two additional spells from any class at 18th level.", "bard", 14));
        skills.add(new Skill("Peerless Skill", "College of Lore", "When you make an ability check, you can expend one use of" +
                " Bardic Inspiration.  Roll a Bardic Inspiration die and add the number rolled to your ability check.  You can" +
                " choose to do so after you roll the die for the ability check, but before the DM tells you whether you succeed" +
                " or fail.", "bard", 14));
        skills.add(new Skill("Bardic Inspiration 4", null, "You can inspire others through stirring words or music.  To do so, you use a bonus" +
                " action on your turn to choose one creature other than yourself within 60 feet of you who can hear you.  That" +
                " creature gains one Bardic Inspiration die, a d12.  Once within the next 10 minutes, the creature can roll the die" +
                " and add the number rolled to one ability check, attack roll, or saving throw it makes.  The creature can wait" +
                " until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says" +
                " whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost.  A creature can have only" +
                " Bardic Inspiration die at a time.  You can use this feature a number of times equal to your Charisma modifier" +
                " (minimum of once).  You regain any expended uses when you finish a long rest.", "bard", 15));
        skills.add(new Skill("Song of Rest 4", null, "You can use soothing music or oration to help revitalize your wounded allies during" +
                " a short rest.  If you or any friendly creatures who can hear your performance regain hit points at the end of the" +
                " short rest by spending one or more Hit Dice, each of those creatures regains an extra 1d12 hit points.",
                "bard", 17));
        skills.add(new Skill("Magical Secrets 3", null, "Choose another two spells from any class, including this one. A spell" +
                " you choose must be of a level you can cast, as shown on the Bard table, or a cantrip.  The chosen spells" +
                " count as bard spells count as bard spells for you and are included in the number in the Spells Known" +
                " column of the Bard table.", "bard", 18));
        skills.add(new Skill("Superior Inspiration", null, "When you roll initiative and have no uses of Bardic Inspiration left," +
                " you regain one use.", "bard", 20));
        
        // cleric skills
        skills.add(new Skill("Spellcasting", null, "As a conduit for divine power, you can cast cleric spells.  At 1st level, you know" +
                " three cantrips fo your choice from the cleric spell list.  You learn additional cleric cantrips of your choice at" +
                " higher levels.", "cleric", 1));
        skills.add(new Skill("Blessings of Knowledge", "Knowledge Domain", "You learn two languages of your choice.  You also" +
                " become proficient in your choice of two of the folllowing skills: Arcana, History, Nautre, or Religion." +
                "  Your proficiency bonus is doubled for any ability check you make that uses either of those skills.",
                "cleric", 1));
        skills.add(new Skill("Channel Divinity", null, "You gain the ability to channel divine energy directly from your deity, using" +
                " that energy to fuel magical effects.  You can only use this feature once per long or short rest.", "cleric", 2));
        skills.add(new Skill("Channel Divinity - Turn Undead", null, "As an action, you present your holy symbol and speak a prayer" +
                " censuring the undead.  Each undead that can see or hear you within 30 feet of you must make a wisdom saving" +
                " throw.  If the creature fails its saving throw, it is turned for 1 minute or until it takes any damage." +
                "  A turned creature must spend its turns trying to move as far away from you as it can, and it can't" +
                " willingly move to a space wthin 30 feet of you.  It also can't take reactions  For its action,l it can" +
                " use only the Dash action or try to escape from an effect that prevents it from moving.  If there's nowhere" +
                " to move, the creature can use the Dodge action.", "cleric", 2));
        skills.add(new Skill("Knowledge of the Ages", "Knowledge Domain", "You can use your Channel Divinity to tap into a" +
                " divine well of knowledge.  As an action, you choose one skill or tool.  For 10 minutes, you have proficiency" +
                " with the chosen skill or tool.", "cleric", 2));
        skills.add(new Skill("Destroy Undead", null, "When an undead fails its saving throw against your Turn Undead feature," +
                " the creature is instantly destroyed if its challenge rating is 1/2 or lower.", "cleric", 5));
        skills.add(new Skill("Channel Divinity 2", null, "You can now use Channel Divinity features twice per long or short rest.",
                "cleric", 6));
        skills.add(new Skill("Read Thoughts", "Knowledge Domain", "You can use your Channel Divinity to read a creature's" +
                " thoughts.  You can then use your access to the creature's mind to command it.  As an action, choose one" +
                " creature that you can see within 60 feet of you.  That creature must make a Wisdom saving throw.  If the" +
                " creature succeeds on the saving throw, you can't use this feature on it again until you finish a long rest." +
                "  If the creature fails its save, you can read its surface thoughts when it is within 60 feet of you." +
                "  This effect lasts for 1 minute.  During that time, you can use your action to end this effect and cast" +
                " the suggestion spell on the creature without expending a spell slot.  The target automatically fails its" +
                " saving throw against the spell", "cleric", 6));
        skills.add(new Skill("Destroy Undead 2", null, "When an undead fails its saving throw against your Turn Undead feature," +
                " the creature is instantly destroyed if its challenge rating is at or below a 1.", "cleric", 8));
        skills.add(new Skill("Potent Spellcasting", "Knowledge Domain", "Add your Wisdom modifier to the damage you deal with" +
                " any cleric cnatrip.", "cleric", 8));
        skills.add(new Skill("Divine Intervention", null, "You can call on your deity to intervene on your behalf when your need" +
                " is great.  Imploring your deity's aid requires you to use your action.  Describe the assistance you seek,"
                + " and roll percentile dice.  If you roll a number equal to or lower than your cleric level, your deity"
                + " intervenes.  The DM chooses the nature of the intervention; the effect of any cleric spell or cleric "
                + "deomain spell would be appropriate.  If your deity intervenes, you can't use this feature again for 7 days."
                + "  Otherwise, you can use it again after you finish a long rest.", "cleric", 10));
        skills.add(new Skill("Destroy Undead 3", null, "When an undead fails its saing throw against your Turn Undead feature, the"
                + " creature is instantly destroyed if its challenge rating is at or below 2.", "cleric", 11));
        skills.add(new Skill("Destroy Undead 4", null, "When an undead fails its saing throw against your Turn Undead feature, the"
                + " creature is instantly destroyed if its challenge rating is at or below 3.", "cleric", 14));
        skills.add(new Skill("Destroy Undead 5", null, "When an undead fails its saing throw against your Turn Undead feature, the"
                + " creature is instantly destroyed if its challenge rating is at or below 4.", "cleric", 17));
        skills.add(new Skill("Visions of the Past", "Knowledge Domain", "You can call up visions of the past that relate "
                + "to an object you hold or your immediate surroundings.  You spend at least 1 minute in medtation and"
                + " prayer, then receive dreamlike, shadowy glimpses of recent events.  You can meditate in this way for"
                + " a number of minutes equal to your Wisdom score and must maintain concentration during that time,"
                + " as if you were casting a spell.<br /><b>Object Reading</b><br />Holding an object as you meditate, you can"
                + " see visions of the object's previous owner.  After meditating for 1 minute, you learn how the owner"
                + " aquired and lost the object, as well as the most recent significant event involving the object and"
                + " that owner.If the object was owned by anotehr creature in the recent past (within a number of days"
                + " equal to your Wisdom score) you can spend 1 additional minute for each owner to learn the same"
                + " information about that creature.<br /><b>Area Reading</b><br />As you mediate, you see visions of"
                + " recent events in your immediate vicinity (a room, street, tunnel, clearing, or the like, up to a"
                + " 50-foot cube), going back a number of days equal to your Wisdom score.  For each minute you meditate,"
                + " you learn about one significant event, beginning with the most recent.  Significant events typically"
                + " involve powerful emotions, such as battles and betrayals, marriages and murders, births and funerals."
                + "  However, they might also include more mundane events that are nevertheless important in your current"
                + " situation.", "cleric", 17));
        skills.add(new Skill("Channel Divinity 3", null, "You can now use Channel Divinity features three times per long or short rest.",
                "cleric", 18));
        skills.add(new Skill("Divine Intervention Improvement", null, "Your call for intervention succeeds automatically,"
                + " no roll required.", "cleric", 20));
        
        // Druid Skills
        skills.add(new Skill("Druidic", null, "You know Druidic, the secret language of druids.  You can speak the language and use"
                + " it to leave hidden messages.  You and others who know this language automatically spot such a message."
                + "  Others spot the message's presence with a successful DC 15 Wisdom (Perception) check but can't decipher"
                + " it without magic.", "druid", 1));
        skills.add(new Skill("Spellcasting", null, "Drawing on the divine essence of nature itself, you can cast cpells to shape that essence to your will.<br />"
                + "<b>Cantrips</b><br />At 1st level, you know two cantrips of your choice from the druid spell list.  You"
                + " learn additional druid cantrips of your choice at higher levels.", "druid", 1));
        skills.add(new Skill("Wild Shape", null, "You can use your action to magically assume the shape of a beast that you have"
                + " seen before.  You can use this feature twice per short or long rest.<br />Your druid level determines"
                + " the beasts you can transform into.  At level two, you can change into beasts with a max challenge rating"
                + " of 1/4, and that don't have a flying or swimming speed.<br />You can stay in beast shape for a number"
                + " of hours equal to half your druid level (rounded down).  You revert to your normal form unless you expend"
                + " another use of this feature.  You can revert early by using a bonus action on your turn.  You"
                + " automatically revert if you fall unconscious, drop to 0 hit points, or die.<br /> - Your stats are"
                + " replaced by the stats of the beast, but you retain alignment, personality, and Intelligence, Wisdom,"
                + " and Charisma scores.<br /> - When you transform, you assume the beast's hit points and Hit Dice.  When"
                + " you revert to your normal form, yoiu return to the number of hit points you had before you transformed."
                + "  However, if you revert as a result of hitting 0 hit points, any excess damage carries over.<br />"
                + "- You can't cast spells, and your ability to speak or take any action that requires hands is limited to the "
                + "capabilities of your beast form.  Transforming does NOT break your concentration on a spell you've already"
                + " cast, or prevent you from taking actions that are part of a spell, such as Call Lightning, that you've"
                + " already cast.<br /> - You retain the benefit of any features from your class, race, or other source nad"
                + " can use them if the new form is physicaly capable of doing so.  However, you can't use any of your special"
                + " senses, such as darkvision, unless your new form also has that sense.<br /> - You chooses whether your"
                + " equipment falls to the ground in your space, merges into your new form, or is worn by it.  Worn equipment"
                + " functions as normal, but the DM decides whether it is practical for the new form to wear a piece of"
                + " equipment, based ont he creature's shape and size.", "druid", 2));
        skills.add(new Skill("Bonus Cantrip", "Circle of the Land", "When you choose this circle at 2nd level, you learn one"
                + " additional druid cantrip of your choice.", "druid", 2));
        skills.add(new Skill("Natural Recovery", "Circle of the Land", "You can regain some of your magical energy by sitting"
                + " in meditation and communing with nature.  During a short rest, you choose expended spell slots to recover."
                + "  The spell slots can have a combined level that is equal to or less than half your druid level (rounded up),"
                + " and none of the slots can be 6th level or higher.  You can't use this feature again until you finish a"
                + " long rest.<br />For example when you are a 4th level druid, you can recover up to two levels worth of spell"
                + " slots.  You can recover either one 1nd-level slot, or two 1st-level slots.", "druid", 2));
        skills.add(new Skill("Wild Shape Improvement", null, "You can now turn into a beast with a maximum Challenge Rating of"
                + " 1/2, and that has no flying speed.", "druid", 4));
        skills.add(new Skill("Land's Stride", "Circle of the Land", "Moving through nonmagical difficult terrain costs you no"
                + " extra movement.  You can also pass through nonmagical plants without being slowed by them and without"
                + " taking damage from them if they have thorns, spines, or a similar hazard.<br />In addition, you have"
                + " advantage on saving throws against plants that are magically created or manipulated to impede mavement,"
                + " such as those created by the Entangle spell.", "druid", 6));
        skills.add(new Skill("Wild Shape Improvement", null, "You can now turn into a beast with a maximum Challenge Rating of 1.",
                "druid", 8));
        skills.add(new Skill("Nature's Ward", "Circle of the Land", "You can't be charmed or frightened by elementals or fey,"
                + " and you are immune to poison and disease.", "druid", 10));
        skills.add(new Skill("Nature's Sanctuary", "Circle of the Land", "Creatures of the natural world sense your connection"
                + " to nature and become hesitant to attack you.  When a beast or plant creature attacks you, that creature"
                + " must make a Wisdom saving throw against your druid spell save DC.  On a failed save, the creature must"
                + " choose a different target, or the attack automatically misses.  On a successful save, the creature is"
                + " immune to this effect for 24 hours.<br />Th creature is aware of this effect before it makes its attack"
                + " against you.", "druid", 14));
        skills.add(new Skill("Timeless Body", null, "The primal magic that you wield causes you to age more slowly.  For every 10"
                + " years that pass, your body ages only 1 year.", "druid", 18));
        skills.add(new Skill("Beast Spells", null, "You can cast many of your druid spells in any shape you assume using WIld Shape."
                + "  You can perform the somatic and verbal components of a druid spell while in a beast shape, but you aren't"
                + " able to provide material components.", "druid", 18));
        skills.add(new Skill("Archdruid", null, "You can use your Wild Shape an unlimited number of times.", "druid", 20));
        
        // fighter skills
        skills.add(new Skill("Fighting Style - Dueling", null, "When you are wielding a mellee weapon in one hand and no other"
                + " weapons, you gain a +2 bonus to damage rolls with that weapon.", "fighter", 1));
        skills.add(new Skill("Second Wind", null, "You have a limited well of stamina that you can draw on to protect yourself from"
                + " harm.  On your turn, you can use a bonus action to regain hit points equal to 1d10 + your fighter level."
                + "  Once you use this feature, you msut finish a short or long rest before you can use it again.", "fighter", 1));
        skills.add(new Skill("Action Surge", null, "You can push yourself beyond your normal limits for a moment.  On your turn, you"
                + " can take one additional action on top of your regular action and a possible bonus action.<br />Once you"
                + " use this feature, you must finish a short or long rest before you can use it again", "fighter", 2));
        skills.add(new Skill("Improved Critical", "Champion", " Your weapon attacks score a critical hit on a roll of 19 or 20.",
                "fighter", 3));
        skills.add(new Skill("Extra Attack", null, "You can attack twice, instead of once, whenever you take the Attack action on"
                + " your turn.", "fighter", 5));
        skills.add(new Skill("Remarkable Athlete", "Champion", "You can add half your proficiency bonus (round up) to any"
                + " Strength, Dexterity, or Constitution check you make that doesn't already use your proficiency bonus."
                + "<br />In addition, when you make a running long jump, the distance you can cover increases by a number"
                + " of feet equal to your Strength modifier.", "fighter", 7));
        skills.add(new Skill("Indomitable", null, "You can reroll a saving throw that you fail.  If you do so, you must use the"
                + " new roll, and you can't use this feature again until you fnish a long rest.", "fighter", 9));
        skills.add(new Skill("Additional Fighting Style", "Champion", "Choose a second option from the Fighting Style class"
                + " feature.", "fighter", 10));
        skills.add(new Skill("Extra Attack 2", null, " You can attack three times, instead of twice, whenever you take the Attack"
                + " action on your turn.", "fighter", 11));
        skills.add(new Skill("Indomitable 2", null, "You can now use Indomitable twice per long rest", "fighter", 13));
        skills.add(new Skill("Superior Critical", null, " Your weapon attacks score a critical on a roll of 18-20", "fighter", 15));
        skills.add(new Skill("Action Surge 2", null, "Can now use Action Surge twice per short or long rest, but only once per turn.",
                "fighter", 17));
        skills.add(new Skill("Indomitable 3", null, "You can now use Indomitable three times per long rest", "fighter", 17));
        skills.add(new Skill("Survivor", "Champion", "You attain the pinnacle of resilience in battle.  At the start of each"
                + " of your turns, you regain hit points equal to 5 + your Constitution modifier if you have no more than half"
                + " of your hit points left.  You don't gain this benefit if you have 0 hit points.", "fighter", 18));
        skills.add(new Skill("Extra Attack 3", null, "You can attack four times, instead of three, whenever you take the Attack"
                + " action on your turn.", "fighter", 20));
        
        // monk skills
        skills.add(new Skill("Unarmored Defense", null, "While you are wearing no armor and not wielding a sheld, your AC equals 10"
                + " + your Dexterity modifier + your Wisdom modifier.", "monk", 1));
        skills.add(new Skill("Martial Arts", null, "Your practice of martial arts gives you mastery of combat styles that use"
                + " unarmed strikes and monk wepons, which are shortswords and any simple melee weapons that don't have the"
                + " two-handed or heapy prperty.<br />You gain the following benefits while you are unarmed or wielding only"
                + " monk weapons and you aren't wearing armor or wielding a shield.<br /> - You can use Dexterity instead of"
                + " Strength for the attack and damage rolls of you unarmed strikes and monk weapons.<br /> - You can roll a"
                + " d4 in place of the normal damage of your unarmed strike or monk weapon.  This die changes as you gain monk"
                + " levels.<br /> - When you use the Attack action with an unarmed strike or a monk weapon on your turn, you"
                + " can make one unarmed strike as a bonus action . For example, if you take the Attack action and attack with"
                + " a quarter-staff, you can also make an unarmed strike as a bonus action assuming you haven't already taken"
                + " a bonus action this turn.", "monk", 1));
        skills.add(new Skill("Ki", null, "Your training allows you to harness the mystic energy of ki.  Your access to this energy"
                + " is represented by a number of ki points.  Your monk level determines the number of points you have.<br />"
                + " You can spend these points to fuel various ki features.  You start knowing three such features: Flurry of"
                + " Blows, Patient Defense, and Step of the Wind.  You learn more ki features as you gain levels in this"
                + " class.<br /> When you spend a ki point, it is unavailable until you finish a short or long rest, at the end"
                + " of which you draw all of your expended ki back into yourself.  You must spend at least 30 minutes of the"
                + " rest meditating to regain your ki points.<br />Some of your ki features require your target to make a"
                + " saving throw to resist the feature's effects the saving throw DC is calculated as follows:<br />"
                + "<b>Ki save DC</b> = 8 + your proficiency bonus + your Wisdom modifier", "monk", 2));
        skills.add(new Skill("Unarmored Movement", null, "Your speed increases by 10 feeet while you are not wearing armor or"
                + " wielding a shield.  The bonus increases when you reach certain monk levels.<br />At 9th level, you gain"
                + " the ability to move along vertical surfaces and across liquids on your turn wihtout falling during the move.",
                "monk", 2));
        skills.add(new Skill("Open Hand Technique", "Way of the Open Hand", "You can manipulate your enemy's ki when you harness"
                + " your own.  Whenever you hit a creature with one of theattacks granted by your Flurry of Blows, you can"
                + " impose one of the following effects on that target:<br /> - It must succeed on a Dexterity saving throw"
                + " or be knocked prone.<br /> - It must make a Strength saving throw.  If it fails, you can push it up to 15"
                + " feet away from you.<br /> - It can't take reactions until the end of your next turn.", "monk", 3));
        skills.add(new Skill("Deflect Missiles", null, "You can use your reactiont odeflect or catch the missile when you are hit"
                + " by a ranged weapon attack.  When you do so, the damage you take from teh attack is reduced by 1d10 + your"
                + " Dexterity modifier + your monk level.<br />If you reduce the damage to 0, you can catch the missile if it"
                + " is small enough for you to hold in one hand and you have at least one hand free.  If you catch a missile"
                + " in this way, you can spend 1 ki point to make a ranged attack with the weapon or pice of ammunition you"
                + " just caught, as part of the same reaction.  You make this attack with proficiency, regardless of your weapon"
                + " proficiencies, and the missile counts as a monk weapon for the attack, which has a normal range of 20 feet"
                + " and a long range of 60 feet.", "monk", 3));
        skills.add(new Skill("Slow Fall", null, "You can use your reaction when you fall to reduce any falling damage you take by an"
                + " amount equal to five times your monk level.", "monk", 4));
        skills.add(new Skill("Extra Attack", null, "You can attack twice, instead of once, whenever you take the Attack action on your turn.",
                "monk", 5));
        skills.add(new Skill("Stunning Strike", null, "You can interfere with the flow of ki in an opponent's body.  When you hit another"
                + " creature with a melee weapon attack, you can spend 1 ki point to attempt a stunning strike.  The target must"
                + " succeed on a Constitution saving throw or be stunned until the end of your next turn.", "monk", 5));
        skills.add(new Skill("Ki-Empowered Strikes", null, "Your unarmed strikes count as magical for the purpose of overcoming resistance"
                + " and immunity to nonmagical attacks and damage.", "monk", 6));
        skills.add(new Skill("Wholeness of Body", "Way of the Open Hand", "You gain the ability to heal yourself.  As an action, you"
                + " can regain hit points equal to three times your monk level.  You must finish a long rest before you can use this"
                + " feature again.", "monk", 6));
        skills.add(new Skill("Evasion", null, "Your instinctive agility lets you dodge out of the way of certain area effects, such as"
                + " a blue dragon's lightning breath or a fireball spell.  When you are subjected to an effect that allows you to"
                + " make a Dexterity saving throw to take only half damage, you instead take no damage if you succeed on the saving"
                + " throw, and only half damage if you fail.", "monk", 7));
        skills.add(new Skill("Stillness of Mind", null, "You can use your action to end one effect on yourself that is causing you to be"
                + " charmed or frightened.", "monk", 7));
        skills.add(new Skill("Unarmored Movement 2", null, "You now have the ability to move along vertical surfaces and across liquids"
                + " on your turn wihtout falling during the move.", "monk", 9));
        skills.add(new Skill("Purity of Body", null, "Your mastery of the ki flowing through you makes you immune to disease and poison.",
                "monk", 10));
        skills.add(new Skill("Tranquility", "Way of the Open Hand", "You can enter a special meditation that surrounds you with an"
                + " aura of peace.  At the end of a long rest, you gain the effect of a Sanctuary spell that lasts until the start"
                + " of your next long rest (the spell can end early as normal).  The saving throw DC for the spell equals 8 + your"
                + " Wisdom modifier + your proficiency bonus.", "monk", 11));
        skills.add(new Skill("Tongue of the Sun and Moon", null, "You learn to touch the ki of other minds so that you understand all"
                + " spoken languages.  Moreover, any creature that can understand a language can understand what you say.", "monk", 13));
        skills.add(new Skill("Diamond Soul", null, "Your mastery of ki grants you proficiency in all saving throws.<br />Additionally,"
                + " whenever you make a saving throw and fail, you can spend 1 ki point to reroll it and take the second result.",
                "monk", 14));
        skills.add(new Skill("Timeless Body", null, "Your ki sustains you so that you suffer none of the frailty of old age, and you can't"
                + " be aged magically.  You can still die of old age, however.  In addition, you no longer need food or water.",
                "monk", 15));
        skills.add(new Skill("Quivering Palm", "Way of the Open Hand", "You gain the ability to set up lethal vibrations in someone's"
                + " body.  When you hit a creature with an unarmed strike, you can spend 3 ki points to start these imperceptible"
                + " vibrations, which last for a number of days equal to your monk level.  The vibrations are harmless unless you"
                + " use your action to end them.  To do so, you and the target must be ont he same plane of existence.  When you"
                + " use this action, the creature must make a Constitution saving throw.  If it fails, it is reduced to 0 hit points."
                + "  If it succeeds, it takes 10d10 necrotic damage.<br />You can have only one creature under the effect of this"
                + " feature at a time.  You can choose to end the bibrations harmlessly without using an action.", "monk", 17));
        skills.add(new Skill("Empty Body", null, "You can use your action to spend 4 ki points to become invisible for 1 minute.  During"
                + " that time, you also have resistance to all damage but force damage.<br />Additionally, you can spend 8 ki"
                + " points to cast the Astral Projection spell, without needing material componenets.  When you do so, you can't"
                + " take any other creatures with you.", "monk", 18));
        skills.add(new Skill("Perfect Self", null, "When you roll for initiative and have no ki points remainig, you regain 4 ki points.",
                "monk", 20));
        
        //paladin skills
        skills.add(new Skill("Divine Sense", null, "The presence of strong evil registers on your senses like a noxious odor, and powerful"
                + " good rings like heavenly music in your ears.  As an action, you can open your awareness to detect such forces."
                + "  Until the end of your next turn, you know the location of any celestial, fiend, or undead within 60 feet of you"
                + " that is not behind total cover.  You know the type (celestial, fiend, or undead) of any being whose presence you"
                + " sense, but not its identity (the vampire Count Strahd von Zarovich, for instance).  Within the same radius, you"
                + " also detect the presence of any place ore object that has been consecrated or desecrated, as with the Hallow"
                + " spell.<br />You can use this feature a number of times equal to 1 + your Charisma modifier.  When you finish a"
                + " long rest, you regain all expended uses.", "paladin", 1));
        skills.add(new Skill("Lay on Hands", null, "Your blessed touch can heal wounds.  You have a pool of healing power that replenishes"
                + " when you take a long rest.  With that pool, you can restore a total number of hit points equal to your paladin"
                + " livel times 5.<br />As an action, you can touch a creature and draw power from the pool to restore a number of"
                + " hit points to that creature, up to the maximum amount remaining in your pool.<br />Alternatively, you can expend"
                + " 5 hit points from your pool of healing to cure the target of one disease or neutralize one poison affecting it."
                + "  You can cure multiple diseases and neutralize multiple poisons with a single use of Lay on Hands, expending hit"
                + " points separately for each one.<br />This feature has no effect on undead and constructs.", "paladin", 1));
        skills.add(new Skill("Fightnig Style - Dueling", null, "When you are wielding a melee weapon in one hand and no other weapons,"
                + " you gain a +2 bonus to damage rolls with taht weapon.", "paladin", 2));
        skills.add(new Skill("Spellcasting", null, "You have learned to draw on divine magic through meditation and prayer to cast spells"
                + " as a cleric does.<br />Charisma is your spellcasting ability for your paladin spells, since their power derives"
                + " from the strength of your convictions.  You use your Charisma whenever a spell refers to your spellcasting ability."
                + "  In addition, you use your Charisma modifier when setting the saving throw DC for a paladin spell you cast and"
                + " when making an attack roll with one.<br /><b>Spell save DC</b> = 8 + proficiency bonus + Charisma modifier<br />"
                + "<b>Spell attack modifier</b> = proficiency bonus + charisma modifier", "paladin", 2));
        skills.add(new Skill("Divine Smite", null, "When you hit a creature with a melee weapon attack, you can expend one spell slot to"
                + " deal radiant damage to the target, in addition to the weapon's damage.  The extra damage is 2d8 for a 1st-level"
                + " spell slot, plus 1d8 for each spell level higher than 1st, to a maximum of 5d8.  The damage increases by 1d8 if"
                + " the target is an undead or a fiend.", "paladin", 2));
        skills.add(new Skill("Divine Health", null, "The divine magic flowing through you makes you immune to disease.", "paladin", 3));
        skills.add(new Skill("Channel Divinity", "Oath of Devotion", "When you take this oath, you gain the following twoo Channel"
                + " Divinity options.<br /><b>Sacred Weapon.</b>  As anaction, you can imbue one weapon that you are holding with"
                + " positive energy, using your Channel Divinity.  For 1 minute, you add your Charisma modifier to attack rolls made"
                + " with that weapon (with a minimum bonus of +1).  The weapon also emits bright light in a 20-foot radius and dim"
                + " light 20 feet beyound that.  If the weapon is not already magical, it becomes magical for the duration.<br />You"
                + " can end this effect on your turn as part of any other action . If you are no longer holding or carrying this"
                + " weapon, or if you fall unconscious, this effect ends.<br /><b>Turn the Unholy.</b>  As an action, you present"
                + " your holy sumbol and speak a prayer censuring fiends and undead, using your Channel Divinity.  Each fiend or"
                + " undead that can see or hear you within 30 feet of you must make a Wisdom saving throw.  If the creature fails"
                + " its saving throw, it is turned for 1 minute or until it takes damage.<br />A turned creature must spend its turns"
                + " trying to move as far awya from you as it can, and it can't willingly move to a space within 30 feet of you."
                + "  It also can't take reactions.  For its action, it can only use the Dash action or try to escape from an effect"
                + " that prevents it from moving.  If there's nowhere to move, the creature can use the Dodge action.", "paladin", 3));
        skills.add(new Skill("Extra Attack", null, "You can attack twice, instead of once, whenever you take the Attack action on your turn",
                "paladin", 5));
        skills.add(new Skill("Aura of Protection", null, "Whenever you or a friendly creature within 10 feet of you must make a saving"
                + " throw, the creature gains a bonus to the saving throw equal to your Charisma modifier (with a minimum bonus of"
                + " +1).  You must be conscious to grant this bonus.<br />At 18th level, the range of this aura increases to 30"
                + " feet.", "paladin", 6));
        skills.add(new Skill("Aura of Devotion", "Oath of Devotion", "You and friendly creatures within 10 feet of you can't be charmed"
                + " while you are conscious.<br />At 18th level, the range of this aura increases to 30 feet.", "paladin", 7));
        skills.add(new Skill("Aura of Courage", null, "You and friendly creatures within 10 feet of you can't be frightened while you are"
                + " conscious.<br />At 18th level, the range of this aura increases to 30 feet.", "paladin", 10));
        skills.add(new Skill("Divine Smite 2", null, "You are so suffused with righteous might that all your melee weapon strikes carry"
                + " divine power with them.  Whenever you hit a creature witha melee weapon, the creature takes an extra 1d8 radiant"
                + " damage.  If you also use your Divine Smite with an attack, you add this damage to the extra damage of your Divine"
                + " Smite.", "paladin", 11));
        skills.add(new Skill("Cleansing Touch", null, "You can use your action to end one spell on yourself or on one willing creature"
                + " that you touch.<br />You can use this feature a number of times equal to your Charisma modifier (a minimum"
                + " of once).  You regain expended uses when you finish a long rest.", "paladin", 14));
        skills.add(new Skill("Purity of Spirit", "Oath of Devotion", "You are always under the effects of a Protection from"
                + " Evil and Good spell", "paladin", 15));
        skills.add(new Skill("Aura Improvement", null, "The range of Aura features is increased to 30 feet", "paladin", 18));
        skills.add(new Skill("Holy Nimbus", "Oath of Devotion", "As an action, you can emanate an aura of sunlight.  For 1 minute, bright light shines from you in a 30-foot radius, and dim"
                + " light shines 30 feet beyond that.<br />Whenever an enemy creature starts its turn in the bright light, the"
                + " creature takes 10 radiant damage.<br />In addition, for the duration, you have advantage on saving throws against"
                + " spells cast by fiends or undead.<br />Once you use this feature, you can't use it again until yoyu finish a long"
                + " rest.", "paladin", 20));
        
        // ranger skills
        
    }
    
    
    public void addSkill (Skill newSkill) {
        for (Skill skill : skills) {
            if (skill.getSkillName().equals(newSkill.getSkillName())) {
                throw new IllegalArgumentException("duplicate skill");
            } else {
                skills.add(newSkill);
            }
        }
    }
    
    public Skill[] getSkill (String charClass, int level) {
        Skill foo[] = new Skill[3];
        int fooIndex = 0;
        for (Skill skill : skills) {
            if (skill.getSkillClass().equals(charClass) && skill.getSkillLevel() == level) {
                foo[fooIndex] = skill;
                fooIndex++;
            }
        }
        return foo;
    }
}