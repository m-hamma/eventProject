--
-- PostgreSQL database dump
--

\restrict 8Fd0HblIvtu2dl2lRkgspUxiKeTS3umRFt6tgHTs3gpQRcC0Ygtgty1LdKcX8ZX

-- Dumped from database version 17.11
-- Dumped by pg_dump version 17.11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: event; Type: SCHEMA; Schema: -; Owner: mohamed.hamma
--

CREATE SCHEMA event;


ALTER SCHEMA event OWNER TO "mohamed.hamma";

--
-- Name: referentiel; Type: SCHEMA; Schema: -; Owner: mohamed.hamma
--

CREATE SCHEMA referentiel;


ALTER SCHEMA referentiel OWNER TO "mohamed.hamma";

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: invoices; Type: TABLE; Schema: event; Owner: mohamed.hamma
--

CREATE TABLE event.invoices (
                                id bigint NOT NULL,
                                invoice_number character varying(50) NOT NULL,
                                created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                order_id bigint NOT NULL
);


ALTER TABLE event.invoices OWNER TO "mohamed.hamma";

--
-- Name: invoices_id_seq; Type: SEQUENCE; Schema: event; Owner: mohamed.hamma
--

CREATE SEQUENCE event.invoices_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE event.invoices_id_seq OWNER TO "mohamed.hamma";

--
-- Name: invoices_id_seq; Type: SEQUENCE OWNED BY; Schema: event; Owner: mohamed.hamma
--

ALTER SEQUENCE event.invoices_id_seq OWNED BY event.invoices.id;


--
-- Name: order_items; Type: TABLE; Schema: event; Owner: mohamed.hamma
--

CREATE TABLE event.order_items (
                                   id bigint NOT NULL,
                                   order_id bigint NOT NULL,
                                   quantity integer NOT NULL,
                                   unit_price numeric(38,2) NOT NULL,
                                   product_id bigint
);


ALTER TABLE event.order_items OWNER TO "mohamed.hamma";

--
-- Name: order_items_id_seq; Type: SEQUENCE; Schema: event; Owner: mohamed.hamma
--

CREATE SEQUENCE event.order_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE event.order_items_id_seq OWNER TO "mohamed.hamma";

--
-- Name: order_items_id_seq; Type: SEQUENCE OWNED BY; Schema: event; Owner: mohamed.hamma
--

ALTER SEQUENCE event.order_items_id_seq OWNED BY event.order_items.id;


--
-- Name: orders; Type: TABLE; Schema: event; Owner: mohamed.hamma
--

CREATE TABLE event.orders (
                              id bigint NOT NULL,
                              created_at timestamp without time zone NOT NULL,
                              status character varying(255) NOT NULL,
                              description character varying(500),
                              updated_at timestamp(6) without time zone,
                              libelle character varying(255),
                              client_id bigint NOT NULL
);


ALTER TABLE event.orders OWNER TO "mohamed.hamma";

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: event; Owner: mohamed.hamma
--

CREATE SEQUENCE event.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE event.orders_id_seq OWNER TO "mohamed.hamma";

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: event; Owner: mohamed.hamma
--

ALTER SEQUENCE event.orders_id_seq OWNED BY event.orders.id;


--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: mohamed.hamma
--

CREATE TABLE public.flyway_schema_history (
                                              installed_rank integer NOT NULL,
                                              version character varying(50),
                                              description character varying(200) NOT NULL,
                                              type character varying(20) NOT NULL,
                                              script character varying(1000) NOT NULL,
                                              checksum integer,
                                              installed_by character varying(100) NOT NULL,
                                              installed_on timestamp without time zone DEFAULT now() NOT NULL,
                                              execution_time integer NOT NULL,
                                              success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO "mohamed.hamma";

--
-- Name: order_items; Type: TABLE; Schema: public; Owner: mohamed.hamma
--

CREATE TABLE public.order_items (
                                    id bigint NOT NULL,
                                    quantity integer NOT NULL,
                                    unit_price numeric(38,2) NOT NULL,
                                    order_id bigint NOT NULL,
                                    product_id bigint NOT NULL
);


ALTER TABLE public.order_items OWNER TO "mohamed.hamma";

--
-- Name: order_items_id_seq; Type: SEQUENCE; Schema: public; Owner: mohamed.hamma
--

ALTER TABLE public.order_items ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.order_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: orders; Type: TABLE; Schema: public; Owner: mohamed.hamma
--

CREATE TABLE public.orders (
                               id bigint NOT NULL,
                               created_at timestamp(6) without time zone NOT NULL,
                               customer character varying(255) NOT NULL,
                               description character varying(500),
                               libelle character varying(255) NOT NULL,
                               status character varying(255) NOT NULL,
                               updated_at timestamp(6) without time zone,
                               CONSTRAINT orders_status_check CHECK (((status)::text = ANY ((ARRAY['CREATED'::character varying, 'CONFIRMED'::character varying, 'PREPARING'::character varying, 'SHIPPED'::character varying, 'DELIVERED'::character varying, 'CANCELLED'::character varying])::text[])))
);


ALTER TABLE public.orders OWNER TO "mohamed.hamma";

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: mohamed.hamma
--

ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: clients; Type: TABLE; Schema: referentiel; Owner: mohamed.hamma
--

CREATE TABLE referentiel.clients (
                                     id bigint NOT NULL,
                                     code character varying(50) NOT NULL,
                                     nom character varying(255) NOT NULL,
                                     email character varying(255),
                                     telephone character varying(50)
);


ALTER TABLE referentiel.clients OWNER TO "mohamed.hamma";

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: referentiel; Owner: mohamed.hamma
--

CREATE SEQUENCE referentiel.clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE referentiel.clients_id_seq OWNER TO "mohamed.hamma";

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: referentiel; Owner: mohamed.hamma
--

ALTER SEQUENCE referentiel.clients_id_seq OWNED BY referentiel.clients.id;


--
-- Name: products; Type: TABLE; Schema: referentiel; Owner: mohamed.hamma
--

CREATE TABLE referentiel.products (
                                      id bigint NOT NULL,
                                      code character varying(255) NOT NULL,
                                      libelle character varying(255) NOT NULL,
                                      prix numeric(38,2) NOT NULL
);


ALTER TABLE referentiel.products OWNER TO "mohamed.hamma";

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: referentiel; Owner: mohamed.hamma
--

CREATE SEQUENCE referentiel.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE referentiel.products_id_seq OWNER TO "mohamed.hamma";

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: referentiel; Owner: mohamed.hamma
--

ALTER SEQUENCE referentiel.products_id_seq OWNED BY referentiel.products.id;


--
-- Name: invoices id; Type: DEFAULT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.invoices ALTER COLUMN id SET DEFAULT nextval('event.invoices_id_seq'::regclass);


--
-- Name: order_items id; Type: DEFAULT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.order_items ALTER COLUMN id SET DEFAULT nextval('event.order_items_id_seq'::regclass);


--
-- Name: orders id; Type: DEFAULT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.orders ALTER COLUMN id SET DEFAULT nextval('event.orders_id_seq'::regclass);


--
-- Name: clients id; Type: DEFAULT; Schema: referentiel; Owner: mohamed.hamma
--

ALTER TABLE ONLY referentiel.clients ALTER COLUMN id SET DEFAULT nextval('referentiel.clients_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: referentiel; Owner: mohamed.hamma
--

ALTER TABLE ONLY referentiel.products ALTER COLUMN id SET DEFAULT nextval('referentiel.products_id_seq'::regclass);


--
-- Name: invoices invoices_invoice_number_key; Type: CONSTRAINT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.invoices
    ADD CONSTRAINT invoices_invoice_number_key UNIQUE (invoice_number);


--
-- Name: invoices invoices_pkey; Type: CONSTRAINT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.invoices
    ADD CONSTRAINT invoices_pkey PRIMARY KEY (id);


--
-- Name: order_items order_items_pkey; Type: CONSTRAINT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.order_items
    ADD CONSTRAINT order_items_pkey PRIMARY KEY (id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: mohamed.hamma
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: order_items order_items_pkey; Type: CONSTRAINT; Schema: public; Owner: mohamed.hamma
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_items_pkey PRIMARY KEY (id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: mohamed.hamma
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: clients clients_code_key; Type: CONSTRAINT; Schema: referentiel; Owner: mohamed.hamma
--

ALTER TABLE ONLY referentiel.clients
    ADD CONSTRAINT clients_code_key UNIQUE (code);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: referentiel; Owner: mohamed.hamma
--

ALTER TABLE ONLY referentiel.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: products products_code_key; Type: CONSTRAINT; Schema: referentiel; Owner: mohamed.hamma
--

ALTER TABLE ONLY referentiel.products
    ADD CONSTRAINT products_code_key UNIQUE (code);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: referentiel; Owner: mohamed.hamma
--

ALTER TABLE ONLY referentiel.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: mohamed.hamma
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- Name: invoices fk_invoice_order; Type: FK CONSTRAINT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.invoices
    ADD CONSTRAINT fk_invoice_order FOREIGN KEY (order_id) REFERENCES event.orders(id);


--
-- Name: order_items fk_order_item_order; Type: FK CONSTRAINT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.order_items
    ADD CONSTRAINT fk_order_item_order FOREIGN KEY (order_id) REFERENCES event.orders(id);


--
-- Name: order_items fkocimc7dtr037rh4ls4l95nlfi; Type: FK CONSTRAINT; Schema: event; Owner: mohamed.hamma
--

ALTER TABLE ONLY event.order_items
    ADD CONSTRAINT fkocimc7dtr037rh4ls4l95nlfi FOREIGN KEY (product_id) REFERENCES referentiel.products(id);


--
-- Name: order_items fkbioxgbv59vetrxe0ejfubep1w; Type: FK CONSTRAINT; Schema: public; Owner: mohamed.hamma
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT fkbioxgbv59vetrxe0ejfubep1w FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- Name: order_items fkocimc7dtr037rh4ls4l95nlfi; Type: FK CONSTRAINT; Schema: public; Owner: mohamed.hamma
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT fkocimc7dtr037rh4ls4l95nlfi FOREIGN KEY (product_id) REFERENCES referentiel.products(id);


--
-- PostgreSQL database dump complete
--

\unrestrict 8Fd0HblIvtu2dl2lRkgspUxiKeTS3umRFt6tgHTs3gpQRcC0Ygtgty1LdKcX8ZX

