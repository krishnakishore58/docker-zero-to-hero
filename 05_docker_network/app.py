from flask import Flask
import psycopg2

app = Flask(__name__)

@app.route('/')
def index():
    try:
        conn = psycopg2.connect(
            dbname="testdb",
            user="testuser",
            password="testpass",
            host="db",  # <--- This is the Docker service name!
        )
        cur = conn.cursor()
        cur.execute("SELECT 'Hello from PostgreSQL!'")
        result = cur.fetchone()
        cur.close()
        conn.close()
        return result[0]
    except Exception as e:
        return str(e)

if __name__ == '__main__':
    app.run(host='0.0.0.0')
