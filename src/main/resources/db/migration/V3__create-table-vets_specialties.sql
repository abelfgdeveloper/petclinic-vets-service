CREATE TABLE vets_specialties (
  vet_id varchar(40) NOT NULL,
  specialty_id varchar(40) NULL
);

ALTER TABLE vets_specialties ADD CONSTRAINT vets_specialties_fk_vet_id FOREIGN KEY (vet_id) REFERENCES vets(id);
ALTER TABLE vets_specialties ADD CONSTRAINT vets_specialties_u UNIQUE (vet_id, specialty_id);