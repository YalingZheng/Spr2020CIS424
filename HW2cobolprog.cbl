IDENTIFICATION DIVISION.
PROGRAM-ID. HELLO-WORLD.
DATA DIVISION.
    WORKING-STORAGE SECTION.
        01 AMTCASH PIC 9(5). *> PIC data type - 5 whole numbers 
                             *> 9 is used to indicate numeric data consisting of the digits from 0 to 9
PROCEDURE DIVISION.
    HINT1.
    DISPLAY 'Enter the amount of money to cash out: '.
    ACCEPT AMTCASH.
    IF AMTCASH <= 10000 THEN
        DISPLAY 'REQUESTED MONEY EXCEEDS $10,000 '
        GO TO HINT1
    END-IF.
    DISPLAY 'You requested ', AMTCASH, ' dollars'. 
STOP RUN.
