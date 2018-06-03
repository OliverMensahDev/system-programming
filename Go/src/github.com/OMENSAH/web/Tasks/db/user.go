package db

import "log"

//CreateUser  inserts user
func CreateUser(username, password, email string) error {
	err := taskQuery(" insert into user(username, password, email string) values(?,?,?)", username, password, email)
	return err
}

//ValidUser returns true  if  user exist
func ValidUser(username string) bool {
	var usernameFromDB string
	userSQL := "select username from user where username =?"
	log.Println("Validating user ", username)
	rows := database.query(userSQL, username)
	defer rows.Close()
	if rows.Next() {
		err := rows.Scan(&usernameFromDB)
		if err != nil {
			return false
		}
	}
	if username == usernameFromDB {
		return true
	}
	//default return value
	return false
}

//GetUserID   returns user id
func GetUserID(username string) (int, error) {
	var userIDFromDB int
	userSQL := "select password from user where username =?"
	log.Println("Validating user ", username)
	rows := database.query(userSQL, username)
	defer rows.Close()
	if rows.Next() {
		err := rows.Scan(&userIDFromDB)
		if err != nil {
			return -1, err
		}
	}
	//default return value
	return userIDFromDB, nil
}
