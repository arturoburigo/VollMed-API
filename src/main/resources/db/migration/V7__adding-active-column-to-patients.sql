alter table patients add active tinyint;
update patients set active = 1;
