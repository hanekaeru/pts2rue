insert into utilisateur
values ('prof', 'prof', 'Professeur', false, null, 'EEJ', 1);
insert into utilisateur
values ('prof2', 'prof2', 'Professeur', false, null, 'ANG', 2);
insert into utilisateur
values ('prof3', 'prof3', 'Professeur', false, null, 'DRT', 3);

insert into Utilisateur
values('etud', 'etud', 'Etudiant', false, 1, NULL, 4);

insert into Utilisateur
values('admin', 'admin', 'Administrateur', true, NULL, 'ORI', 5) ;


insert into question
values('ECC', 1, '2018-06-20', 'En moyenne, un exilé, quelle que soit la raison de son exil, 
reste éloigné de son pays 30 ans. Vrai ou faux ?', 'Vrai', 'Vrai&#&Faux', ' ' ,'qcm', '12', 1, 1);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('ANG', 1, '2018-06-21', 'You are writing an application letter to Mr Vey. Which phrase should you write at the 
end ?', 'YoursSincerely&#&Sincerely', 'Yours Sincerely&#&Sincerely&#&Sincerely Yours&#&Thankely', ' ', 'qcm', '12', 2, 2);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('ANG', 2, '2018-06-22', ' Barack Obama was elected in 2016. True or false ?', 'False', 'True&#&False', ' ', 'qcm', '32', 1, 3);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('DRT', 1, '2018-06-23', 'Parmi les juridictions suivantes, quel est  l’intrus ?',
 'le conseil d Etat', 'le conseil d Etat&#&le TGI&#&le tribunal administratif&#&la cour de cassation&#&le conseil des prud hommes', ' ', 'qcm', '11', 2, 4);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('DRT', 1, '2018-06-24', 'Celui qui prend l initiative du procès est :',
 'le demandeur', 'la victime&#&le demandeur&#&le defendeur&#&le defenseur', ' ', 'qcm', '11', 3, 5);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('DRT', 1, '2018-06-25', 'Mon chien est :', 'Immeuble par nature', 'Immeuble par nature&#&Meuble par nature', ' ', 'qcm', '11', 1, 6);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('DRT', 2, '2018-06-26', 'Lorsqu une clause est déclarée abusive :',
 ' la clause est réputée non écrite mais le contrat continue à s appliquer ', ' la clause est réputée non écrite mais le contrat continue à s appliquer&#&le contrat est nul&#&il faut modifier le contrat', ' ', 'qcm', '21', 1, 7);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('DRT', 2, '2018-06-27', 'Le gage est :', 'une sureté réelle', 'une sureté réelle&#&une sureté personnelle', ' ', 'qcm', '21', 3, 8);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('EMK', 1, '2018-06-28', 'Comment s appelle le % d internautes ayant quitté une page donnée ?',
 'taux de sortie', 'taux de sortie&#&taux de presence', ' ', 'qcm', '12', 3, 9);

insert into question(matiere, niveau, datepubliee, question, bonnereponse, reponses, image, typequestion, ue, idprofesseur, idquestion)
values('EMK', 1, '2018-06-29', 'Comment s appelle le modèle économique qui associe offre basique en libre accès et offre haut de gamme en accès payant?',
 'Freemium', 'Freemium&#&Freedom', ' ', 'qcm', '12', 3, 10);



insert into reponse
values (5.2, 'Freemium', true, 4, 10);

insert into reponse
values (6.44, 'taux de presence', false, 4, 9);



insert into MessageDuJour
values ('Bonjour les amis, voici le message du jour', 4, 1);

insert into Statistique
values(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1);