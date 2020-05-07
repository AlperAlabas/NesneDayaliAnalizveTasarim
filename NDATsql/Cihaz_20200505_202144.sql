--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- Name: Kullanicilar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Kullanicilar" (
    kullanicino integer NOT NULL,
    ad character varying(50),
    soyad character varying(50),
    sifre character varying(50),
    kullaniciadi character varying(6)
);


ALTER TABLE public."Kullanicilar" OWNER TO postgres;

--
-- Name: Kullanicilar_kullanicino_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Kullanicilar_kullanicino_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Kullanicilar_kullanicino_seq" OWNER TO postgres;

--
-- Name: Kullanicilar_kullanicino_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Kullanicilar_kullanicino_seq" OWNED BY public."Kullanicilar".kullanicino;


--
-- Name: Kullanicilar kullanicino; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanicilar" ALTER COLUMN kullanicino SET DEFAULT nextval('public."Kullanicilar_kullanicino_seq"'::regclass);


--
-- Data for Name: Kullanicilar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Kullanicilar" VALUES (1, 'Alper', 'ALABAŞ', '12345', 'alpera');
INSERT INTO public."Kullanicilar" VALUES (2, 'mustafa', 'Ali', '456852', 'mustik');


--
-- Name: Kullanicilar_kullanicino_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Kullanicilar_kullanicino_seq"', 2, true);


--
-- Name: Kullanicilar pk_kullanici; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanicilar"
    ADD CONSTRAINT pk_kullanici PRIMARY KEY (kullanicino);


--
-- PostgreSQL database dump complete
--

