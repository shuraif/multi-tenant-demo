CREATE TABLE public.userdetails (
	phonehash text NOT NULL,
	passwordhash text NOT NULL,
	lastlogin timestamp NOT NULL,
	createdon timestamp NOT NULL,
	CONSTRAINT userdetails_pkey PRIMARY KEY (phonehash)
);
