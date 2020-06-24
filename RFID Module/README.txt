Hardware:
Controller: Arduino Uno
Module: Mạch RFID RC522 NFC 13.56Mhz

Software
Arduino Side: 
+ Library: MFRC522.h (for RFID) - rfid-master.zip
+ Code: RFID_main.ino

Java Software Side:
+ jSerialComm Library

========== Sơ Đồ =============
RFID        Uno         Mega

SDA (SS)    10          53
SCK         13          52
MOSI        11          51
MISO        12          50 
IRQ	    UNUSED      UNUSED
GND         GND         GND
RST         9           9
3.3V        3.3V        3.3V