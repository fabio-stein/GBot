--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: configuration; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE configuration (
    conf_id integer NOT NULL,
    conf_key character varying(20)
);


--
-- Name: configuration_conf_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE configuration_conf_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: configuration_conf_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE configuration_conf_id_seq OWNED BY configuration.conf_id;


--
-- Name: configuration conf_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY configuration ALTER COLUMN conf_id SET DEFAULT nextval('configuration_conf_id_seq'::regclass);


--
-- Data for Name: configuration; Type: TABLE DATA; Schema: public; Owner: -
--

COPY configuration (conf_id, conf_key) FROM stdin;
1	teste
\.


--
-- Name: configuration_conf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('configuration_conf_id_seq', 1, true);


--
-- Name: configuration configuration_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY configuration
    ADD CONSTRAINT configuration_pkey PRIMARY KEY (conf_id);


--
-- PostgreSQL database dump complete
--

