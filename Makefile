# FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/Makefile
# EDIT BY . . . Hassan Ait-Kaci
# ON MACHINE. . Hp-Dv7
# STARTED ON. . Sun Oct 21 02:07:05 2012

# Last modified on Sun Oct 21 02:25:43 2012 by hak

########################################################################
SAY	= @echo "***"
RM	= @\rm -rf
TRASH	= ,* ,.* *~ @*@ .*~ */,* */,.* */*~ */@*@ */.*~
########################################################################
help:
	@echo
	@echo "This makefile manages the generation of Jacc application."
	@echo "You can 'make ...' where '...' is one of:"
	@echo
	@echo "    aql:      to (re)generate the aql application"
	@echo "    calc:     to (re)generate the calc application"
	@echo "    regx:     to (re)generate the regx application"
	@echo "    term:     to (re)generate the term application"
	@echo "    xml:      to (re)generate the xml application"
	@echo "    all:      to do all the above"
	@echo "    tidy:     cleanup this directory"
	@echo "    help:     to print this message"
	@echo
########################################################################
all:	aql calc regx term xml
########################################################################
aql: tidy
	@make -C aql basic
########################################################################
calc: tidy
	@make -C calc basic
########################################################################
regx: tidy
	@make -C regx basic
########################################################################
term: tidy
	@make -C term basic
########################################################################
xml: tidy
	@make -C xml basic
########################################################################
tidy:
	${SAY} "Tidying up trash in ${PWD} (if any) ..."
	${RM} ${TRASH}
########################################################################