DROP TABLE IF EXISTS messages;

DROP TABLE IF EXISTS conversations;

DROP TABLE IF EXISTS users;


CREATE TABLE "users" (
	id SERIAL NOT NULL,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	email TEXT NOT NULL UNIQUE,
	image TEXT NOT NULL,
	status TEXT NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY ("id")
);



CREATE TABLE conversations (
	id SERIAL NOT NULL,
	participant_1 INTEGER NOT NULL,
	participant_2 INTEGER NOT NULL,
	CONSTRAINT conversations_pk PRIMARY KEY ("id")
);



CREATE TABLE messages (
	id SERIAL NOT NULL,
	conversation_id INTEGER NOT NULL,
	content TEXT NOT NULL,
	is_edited BOOLEAN DEFAULT false,
	time BIGINT NOT NULL,
	sender INTEGER NOT NULL,
	CONSTRAINT messages_pk PRIMARY KEY ("id")
);

ALTER TABLE conversations ADD CONSTRAINT "conversations_fk0" FOREIGN KEY ("participant_1") REFERENCES "users"("id");
ALTER TABLE conversations ADD CONSTRAINT "conversations_fk1" FOREIGN KEY ("participant_2") REFERENCES "users"("id");

ALTER TABLE messages ADD CONSTRAINT "messages_fk0" FOREIGN KEY ("conversation_id") REFERENCES "conversations"("id");
ALTER TABLE messages ADD CONSTRAINT "messages_fk1" FOREIGN KEY ("sender") REFERENCES "users"("id");

