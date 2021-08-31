https://tecadmin.net/how-to-install-postgresql-in-ubuntu-20-04/

sudo -u postgres psql

ALTER USER postgres PASSWORD 'newpassword';


\password
OR

psql -c "ALTER USER postgres WITH PASSWORD 'password';" 

sudo -u postgres psql -c "ALTER USER postgres PASSWORD 'password';"















