
create table Utilisateur(
username        varchar(50)     not null,
password        varchar(50)     not null,
userType        char(15)        not null,
administrateur  boolean         not null,
niveau          int                     ,
matiere         varchar(50)             ,
idUtilisateur   int             not null,

constraint pk_Utilisateur primary key (idUtilisateur),
constraint uk_UserName_Utilisateur unique (username),

constraint chk_typeUser check (userType in('Professeur', 'Etudiant', 'Administrateur')),
constraint chk_niveau_Utilisateur check (niveau > 0 and niveau < 3)
);  



create table Question(
matiere         char(10)       not null,
niveau          int            not null,
datePubliee     date           not null,
question        varchar(500)   not null,
bonneReponse    varchar(200)   not null,
reponses        varchar(412)   not null,
image           varchar(1000)          ,
typeQuestion    char(7)        not null,
ue              char(2)        not null,
idProfesseur    int            not null,
idQuestion      int            not null,

constraint pk_Question primary key (idQuestion),
constraint uk_dateQuestion  unique (datePubliee, niveau),

constraint chk_niveau_Question check (niveau > 0 and niveau < 3),
constraint chk_typeQuestion check (typeQuestion in ('qcm', 'ouvert', 'image', 'relie')),
constraint chk_ue check (ue in ('11', '12', '21', '22', '23', '31', '32', '41', '42', '43')),

constraint fk_idProfesseur_Question foreign key (idProfesseur) references Utilisateur(idUtilisateur)
);



create table Statistique(
nombreQuestion                  int      not null,
vitesseMoyenne                  int      not null,
nombreQuestionsRepondues        int      not null,
nombreBonnesQuestions           int      not null,
meilleureSerieBonnesReponses    int      not null,
meilleurClassement              int      not null,
meilleurNombreDePointsSemaine   int      not null,
nombreDeFoisGagnant             int      not null,
points                          int      not null,
classement                      int      not null,
idEtudiant                      int      not null,
idStatistique                   int      not null,
constraint pk_Statistique primary key (idStatistique),
constraint fk_idEtudiant_Statistique foreign key (idEtudiant) references Utilisateur(idUtilisateur)
);



create table Reponse(
temps       int          not null,
reponse     varchar(103)         ,
juste       boolean              ,
idEtudiant  int          not null,
idQuestion  int          not null,

constraint pk_reponse primary key (idEtudiant, idQuestion),
constraint fk_idEtudiant_Reponse foreign key (idEtudiant) references Utilisateur(idUtilisateur),
constraint fk_idQuestion_Reponse foreign key (idQuestion) references Question(idQuestion)
);



create table MessageDuJour(
message         varchar(100)    not null,
idEtudiant      int             not null,
idMessageDuJour int             not null,
constraint pk_MessageDuJour            primary key (idMessageDuJour),
constraint fk_idEtudiant_MessageDuJour foreign key (idEtudiant) references Utilisateur(idUtilisateur)
);