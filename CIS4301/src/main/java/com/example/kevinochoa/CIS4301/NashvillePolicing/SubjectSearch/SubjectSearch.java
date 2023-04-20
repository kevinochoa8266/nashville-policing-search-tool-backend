package com.example.kevinochoa.CIS4301.NashvillePolicing.SubjectSearch;


import org.springframework.jdbc.core.RowMapper;

/*CREATE TABLE SubjectSearch (
        stopID INTEGER,
        officerID VARCHAR(30),
        searchBasis VARCHAR(255),
        friskPerformed NUMBER(1),
        searchVehicle NUMBER(1),
        searchPerson NUMBER(1),
        searchConducted NUMBER(1),
        weaponsFound NUMBER(1),
        drugsFound NUMBER(1),
        contrabandFound NUMBER(1),
        PRIMARY KEY (stopID)
        );*/
public class SubjectSearch {
        private Long stopId;
        private String officerId;
        private String searchBasis;
        private Boolean friskPerformed;
        private Boolean searchVehicle;
        private Boolean searchPerson;
        private Boolean searchConducted;
        private Boolean weaponsFound;
        private Boolean drugsFound;
        private Boolean contrabandFound;

        public SubjectSearch() {
        }

        public Long getStopId() {
                return stopId;
        }

        public void setStopId(Long stopId) {
                this.stopId = stopId;
        }

        public String getOfficerId() {
                return officerId;
        }

        public void setOfficerId(String officerId) {
                this.officerId = officerId;
        }

        public String getSearchBasis() {
                return searchBasis;
        }

        public void setSearchBasis(String searchBasis) {
                this.searchBasis = searchBasis;
        }

        public Boolean getFriskPerformed() {
                return friskPerformed;
        }

        public void setFriskPerformed(Boolean friskPerformed) {
                this.friskPerformed = friskPerformed;
        }

        public Boolean getSearchVehicle() {
                return searchVehicle;
        }

        public void setSearchVehicle(Boolean searchVehicle) {
                this.searchVehicle = searchVehicle;
        }

        public Boolean getSearchPerson() {
                return searchPerson;
        }

        public void setSearchPerson(Boolean searchPerson) {
                this.searchPerson = searchPerson;
        }

        public Boolean getSearchConducted() {
                return searchConducted;
        }

        public void setSearchConducted(Boolean searchConducted) {
                this.searchConducted = searchConducted;
        }

        public Boolean getWeaponsFound() {
                return weaponsFound;
        }

        public void setWeaponsFound(Boolean weaponsFound) {
                this.weaponsFound = weaponsFound;
        }

        public Boolean getDrugsFound() {
                return drugsFound;
        }

        public void setDrugsFound(Boolean drugsFound) {
                this.drugsFound = drugsFound;
        }

        public Boolean getContrabandFound() {
                return contrabandFound;
        }

        public void setContrabandFound(Boolean contrabandFound) {
                this.contrabandFound = contrabandFound;
        }

        @Override
        public String toString() {
                return "SubjectSearch{" +
                        "stopId=" + stopId +
                        ", officerId='" + officerId + '\'' +
                        ", searchBasis='" + searchBasis + '\'' +
                        ", friskPerformed=" + friskPerformed +
                        ", searchVehicle=" + searchVehicle +
                        ", searchPerson=" + searchPerson +
                        ", searchConducted=" + searchConducted +
                        ", weaponsFound=" + weaponsFound +
                        ", drugsFound=" + drugsFound +
                        ", contrabandFound=" + contrabandFound +
                        '}';
        }
}
