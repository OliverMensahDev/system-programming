echo "Changing director to Tasks"
cd $GOPATH/src/github.com/OMENSAH/web/Tasks
echo "creating tables"
cat schema.sql | sqlite3 tasks.db
echo "building the go binary"
go build -o Tasks
echo "starting the binary"
./Tasks
