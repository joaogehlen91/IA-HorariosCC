BIN_DIR=bin/
SRC_DIR=src/
CP = javac
NAME= CalculaHorarios
FLAGS= -cp
EX = java

all:
	mkdir -p $(BIN_DIR)
	$(CP) $(SRC_DIR)*.java -d $(BIN_DIR)

run:
	$(EX) $(FLAGS) $(BIN_DIR) $(NAME)
