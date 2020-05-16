/*
            UNO        MEGA 
SDA (SS)    10          53
SCK         13          52
MOSI        11          51
MISO        12          50
GND         GND         GND
RST         9           9
3.3V        3.3V        3.3V
*/

#include <SPI.h>
#include "MFRC522.h"

#define RST_PIN 9    
#define SS_PIN 10   // Nếu dùng Arduino Mega 2560 thì đổi 10 thành 53
MFRC522 mfrc522(SS_PIN, RST_PIN); 

void setup() {
 Serial.begin(9600); 
 SPI.begin();        
 mfrc522.PCD_Init(); 
}

void loop() 
{ 
  if(mfrc522.PICC_IsNewCardPresent()) 
  {  
    if(mfrc522.PICC_ReadCardSerial()) 
    {
      for (byte i = 0; i < mfrc522.uid.size; i++) 
      {
        Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
        Serial.print(mfrc522.uid.uidByte[i], HEX);   
      } 
      Serial.println();
      mfrc522.PICC_HaltA();         
    }      
  } 
}
