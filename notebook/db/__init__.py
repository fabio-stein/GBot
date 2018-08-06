import psycopg2
def init(config):
    import db.controller
    conn = psycopg2.connect(config.conn_string)
    if not conn.closed:
        print("Connected!")
        db.controller.conn = conn
