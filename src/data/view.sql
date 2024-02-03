create or replace view v_information_parcelle_par_terrain as
select id_tp,utilisateurs.id_utilisateur,utilisateurs.nom,parcelle.id_parcelle,id_terrain,categorie_culture.id_categorie,categorie_culture.nom_categorie,type.id_type,type.nom_type,rendement_par_pieds,prix_unitaire,dimension,nb_pieds,prix as prix_parcelle,date 
from parcelle_par_terrain 
join categorie_culture on parcelle_par_terrain.id_Categorie = categorie_culture.id_categorie 
join parcelle on parcelle_par_terrain.id_parcelle = parcelle.id_parcelle
join utilisateurs on parcelle_par_terrain.id_utilisateur=utilisateurs.id_utilisateur
join type on parcelle_par_terrain.id_type=type.id_type;


create or replace view v_validation_admin_terrain as
select id_tp,utilisateurs.id_utilisateur,utilisateurs.nom,parcelle.id_parcelle,id_terrain,categorie_culture.id_categorie,categorie_culture.nom_categorie,type.id_type,type.nom_type,rendement_par_pieds,prix_unitaire,dimension,nb_pieds,prix as prix_parcelle,date 
from validation_admin_terrain 
join categorie_culture on validation_admin_terrain.id_Categorie = categorie_culture.id_categorie 
join parcelle on validation_admin_terrain.id_parcelle = parcelle.id_parcelle
join utilisateurs on validation_admin_terrain.id_utilisateur=utilisateurs.id_utilisateur
join type on validation_admin_terrain.id_type=type.id_type;


create or replace view demande_terrain as
select id_tp,utilisateurs.id_utilisateur,utilisateurs.nom,parcelle.id_parcelle,id_terrain,categorie_culture.id_categorie,categorie_culture.nom_categorie,type.id_type,type.nom_type,rendement_par_pieds,prix_unitaire,dimension,nb_pieds,prix as prix_parcelle,date 
from demande_terrain 
join categorie_culture on demande_terrain.id_Categorie = categorie_culture.id_categorie 
join parcelle on demande_terrain.id_parcelle = parcelle.id_parcelle
join utilisateurs on demande_terrain.id_utilisateur=utilisateurs.id_utilisateur
join type on demande_terrain.id_type=type.id_type;


create or replace view v_prix_rendement_prevision as 
select id_terrain,id_parcelle,id_utilisateur,nom,(dimension * 4) as nb_pieds,((dimension * 4)*prix_unitaire)as montant,id_categorie,nom_categorie,id_type,nom_type 
from v_information_parcelle_par_terrain;

create or replace view v_sum_prix_rendement_prevision as
select id_utilisateur,nom,sum(montant) as sum_montant 
from v_prix_rendement_prevision group by id_utilisateur,nom;

create or replace view v_rendement_par_qte as
select id_terrain,id_utilisateur,nom,sum((rendement_par_pieds*nb_pieds)) 
from v_information_parcelle_par_terrain group by id_terrain,id_utilisateur,nom;


create or replace view v_prix_rendement_reel as
select id_terrain,id_parcelle,id_utilisateur,nom,(dimension * 6) as nb_pieds,((dimension * 6)*prix_unitaire)as montant,id_categorie,nom_categorie,id_type,nom_type
from v_information_parcelle_par_terrain;

create or replace view v_sum_prix_rendement_reel as 
select id_utilisateur,nom,sum(montant) as sum_montant 
from v_prix_rendement_reel group by id_utilisateur,nom;

create or replace view stat_parcelle as 
select (count(id_parcelle)*100/(select cou  nt(*) from v_information_parcelle_par_terrain)) as stat_parcelle,id_terrain  
from v_information_parcelle_par_terrain group by id_terrain;


create or replace view v_demande_terrain as
SELECT
    dem.id_tp,
    u1.id_utilisateur,
    u1.nom AS votre_nom,
    dem.id_utilisateur_demande,
    u2.nom AS nom_demande,
    p.dimension,
    p.nb_pieds,
    t.description AS description_terrain,
    t.longitude,
    t.latitude,
    t.photo,
    c.nom_categorie,
    type.nom_type,
    dem.date
FROM
    demande_terrain dem
JOIN utilisateurs u1 ON dem.id_utilisateur = u1.id_utilisateur
JOIN utilisateurs u2 ON dem.id_utilisateur_demande = u2.id_utilisateur
JOIN parcelle p ON dem.id_parcelle = p.id_parcelle
JOIN terrain t ON dem.id_terrain = t.id_terrain
JOIN categorie_culture c ON dem.id_categorie = c.id_categorie
JOIN type ON dem.id_type = type.id_type;