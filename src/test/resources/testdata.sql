use chen_onlineShop
GO




DELETE FROM kundeAccount
DELETE FROM verkaeuferAccount
DELETE FROM kategorie
DELETE FROM artikel
DELETE FROM warenKorbArtikel
DELETE FROM bestellung



-- INSERT INTO kundeAccount (kA_id, username, kennwort, Lieferadresse)
    INSERT INTO kundeAccount VALUES('user1','Bernhard','Moskau Straﬂe 1')
INSERT INTO kundeAccount VALUES('Baggci','admin2','Moskau Straﬂe 1')
INSERT INTO kundeAccount VALUES('AppleApfel','admin3','Moskau Straﬂe 1')
INSERT INTO kundeAccount VALUES('Susuwatari','admin4','Moskau Straﬂe 1')
INSERT INTO kundeAccount VALUES('IceCream','admin5','Moskau Straﬂe 1')
INSERT INTO kundeAccount VALUES('Hakler','12345678','Moskau Straﬂe 1')



-- INSERT INTO verkaeuferAccount (vA_id, username, kennwort,besitz)
INSERT INTO verkaeuferAccount VALUES('FleischVerk‰ufer','root1','Berlin Straﬂe 1')
INSERT INTO verkaeuferAccount VALUES('Waffenh‰ndler','root2','Berlin Straﬂe 2')
INSERT INTO verkaeuferAccount VALUES('AllesVerk‰ufer','root3','Berlin Straﬂe 3')



-- INSERT INTO kategorie (kat_id, kat_name)
INSERT INTO kategorie VALUES('nichtVegan')
INSERT INTO kategorie VALUES('Normal Food')
INSERT INTO kategorie VALUES('Waffen')
INSERT INTO kategorie VALUES('Sale')


    -- INSERT INTO artikel (art_id, art_name,art_price,art_Description, art_kat_id, art_vA_id )
INSERT INTO artikel VALUES('BigMac mit Schweinfleisch',140,'ein Produkt',1,1)
INSERT INTO artikel VALUES('FakeTomate mit Rindfleisch',55,'ein Produkt',1,1)
INSERT INTO artikel VALUES('Haribo mit H¸hnerfleisch',999,'ein Produkt',1,1)
INSERT INTO artikel VALUES('Kartoffel mit eRdƒpFel',52,'ein Produkt',2,3)
INSERT INTO artikel VALUES('Tomaten mit Banananana',3,'ein Produkt',2,3)
INSERT INTO artikel VALUES('Fleisch aus Tier',52,'ein Produkt',2,1)
INSERT INTO artikel VALUES('AK45',2,'ein Produkt',3,2)
INSERT INTO artikel VALUES('Fortnite Kinder',1,'ein Produkt',3,2)
INSERT INTO artikel VALUES('old AK33 from Bin Laden',98,'ein Produkt',3,2)
INSERT INTO artikel VALUES('Fake-Taxi Prime',88,'ein Produkt',4,3)
INSERT INTO artikel VALUES('Vergessenskurve von Johann',10000,'ein Produkt',4,3)




-- INSERT INTO warenKorbArtikel (wKA_id, war_art_id, war_kA_id )
INSERT INTO warenKorbArtikel VALUES(1,2)
INSERT INTO warenKorbArtikel VALUES(1,2)
INSERT INTO warenKorbArtikel VALUES(9,2)
INSERT INTO warenKorbArtikel VALUES(8,4)
INSERT INTO warenKorbArtikel VALUES(10,3)
INSERT INTO warenKorbArtikel VALUES(11,6)




-- INSERT INTO bestellung (bes_id, bes_kA_id)
INSERT INTO bestellung VALUES(2)
INSERT INTO bestellung VALUES(4)
INSERT INTO bestellung VALUES(1)
INSERT INTO bestellung VALUES(3)



-- INSERT INTO bestellungsArtikel  (bA_id, bA_art_id,bA_bes_id)
INSERT INTO bestellungsArtikel  VALUES(1,1)
INSERT INTO bestellungsArtikel  VALUES(1,1)
INSERT INTO bestellungsArtikel  VALUES(9,4)
INSERT INTO bestellungsArtikel  VALUES(8,2)
INSERT INTO bestellungsArtikel  VALUES(10,4)
    GO