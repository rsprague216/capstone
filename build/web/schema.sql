/**
 * Author:  Ryan Sprague
 * Created: Jun 26, 2018
 */
DROP TABLE CLASSES;
DROP TABLE SKILLS;
DROP TABLE CHARACTERS;
DROP TABLE USERS;

CREATE TABLE USERS (
    "FIRSTNAME" VARCHAR(32) NOT NULL,
    "LASTNAME" VARCHAR(32) NOT NULL,
    "EMAIL" VARCHAR(64) NOT NULL,
    "USERNAME" VARCHAR(32) NOT NULL,
    "PASSWORD" VARCHAR(1024) NOT NULL,
    "SALT" BLOB NOT NULL,
    "USERID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    UNIQUE("USERNAME"),
    PRIMARY KEY("USERID")
);

CREATE TABLE CHARACTERS (
    "ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "NAME" VARCHAR(32) NOT NULL,
    "RACE" VARCHAR(16) NOT NULL,
    "GENDER" VARCHAR(16) NOT NULL,
    "CHARCLASS" VARCHAR(16) NOT NULL,
    "ALIGNMENT" VARCHAR(32) NOT NULL,
    "LEVEL" INTEGER NOT NULL,
    "HEALTH" INTEGER NOT NULL,
    "HIT_DICE_SIDES" INTEGER NOT NULL,
    "HIT_DIE_NUM" INTEGER NOT NULL,
    "STRENGTH" INTEGER NOT NULL,
    "DEXTERITY" INTEGER NOT NULL,
    "CONSTITUTION" INTEGER NOT NULL,
    "INTELLIGENCE" INTEGER NOT NULL,
    "WISDOM" INTEGER NOT NULL,
    "CHARISMA" INTEGER NOT NULL,
    "USERID" INTEGER NOT NULL,
    FOREIGN KEY ("USERID") REFERENCES USERS("USERID"),
    PRIMARY KEY("ID")
);

CREATE TABLE SKILLS (
    "ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "SKILL" VARCHAR(64) NOT NULL,
    "EFFECT" VARCHAR(2000) NOT NULL,
    "CHARCLASS" VARCHAR(32) NOT NULL,
    "LEVEL" INTEGER NOT NULL,
    "PATH" VARCHAR(64),
    "CHARID" INTEGER NOT NULL,
    FOREIGN KEY ("CHARID") REFERENCES CHARACTERS("ID"),
    PRIMARY KEY("ID")
);

CREATE TABLE CLASSES (
    "ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "CLASSNAME" VARCHAR(64) NOT NULL,
    "HITDIESIDES" INTEGER NOT NULL,
    "CLASSPATH" VARCHAR(64),
    "CLASSLEVEL" INTEGER NOT NULL,
    "CHARID" INTEGER NOT NULL,
    FOREIGN KEY ("CHARID") REFERENCES CHARACTERS("ID"),
    PRIMARY KEY("ID")
);