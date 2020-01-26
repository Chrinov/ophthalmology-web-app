<template>
    <div>
        <div class="user-panel-column-layout">

            <div class="tab-column">

                <ul class="tab-items">
                    <li @click="showVisitEdit" class="tab-item"><p>Visit Edit</p></li>
                    <li @click="showPatientEdit" class="tab-item"><p>Patients Edit</p></li>
                    <li @click="showDoctorsEdit" class="tab-item"><p>Doctors Edit</p></li>
                    <li @click="showUserData" class="tab-item"><p>My Data</p></li>
                </ul>

            </div>

            <div class="appointment-column">

                <VisitGrid v-if="isVisitEdit"/>

                <DoctorGrid v-if="isDoctorEdit"/>

                <PatientGrid v-if="isPatientEdit"/>

                <PatientData v-if="isUserData"/>
            </div>

        </div>
    </div>
</template>

<script>


    import PatientGrid from "@/components/adminPortal/PatientGrid";
    import VisitGrid from "@/components/adminPortal/VisitGrid";
    import DoctorGrid from "@/components/adminPortal/DoctorGrid";
    import PatientData from "@/components/patientPortal/PatientData";

    export default {

        data() {
            return {
                isVisitEdit: true,
                isDoctorEdit: false,
                isPatientEdit: false,
                isUserData: false
            }

        },
        name: "AdminPortal",
        components: {DoctorGrid, VisitGrid, PatientGrid, PatientData},
        methods: {
            showPatientEdit() {
                this.isPatientEdit = true;
                this.isVisitEdit = false;
                this.isDoctorEdit = false;
                this.isUserData = false;

            },
            showVisitEdit() {
                this.isVisitEdit = true;
                this.isDoctorEdit = false;
                this.isUserData = false;
                this.isPatientEdit = false;
            },
            showDoctorsEdit() {
                this.isVisitEdit = false;
                this.isDoctorEdit = true;
                this.isUserData = false;
                this.isPatientEdit = false;
            },
            showUserData() {
                this.isVisitEdit = false;
                this.isDoctorEdit = false;
                this.isUserData = true;
                this.isPatientEdit = false;
            }
        }
    }
</script>

<style scoped>

    .user-panel-column-layout {
        display: flex;
        padding: 0;
        margin: 0%;
        flex-wrap: wrap;
    }

    .user-panel-column-layout .tab-column {
        flex: 1;
        width: 100%;
    }

    .user-panel-column-layout .tab-column ul {
        padding: 0;
        margin: 0;
    }

    .user-panel-column-layout .appointment-column {
        flex: 3;
        align-items: flex-end;
        padding: 20px;
        list-style-type: none;

    }

    .user-panel-column-layout .appointment-column h1 {
        text-align: center;

    }

    .user-panel-column-layout ul {
        list-style-type: none;

    }


    .tab-item {
        padding-bottom: 5rem;
        padding-top: 5rem;
        text-transform: uppercase;
        width: 100%;
        border-style: solid;
        border-color: darkgray;
        text-align: center;
        cursor: pointer;


    }

    .tab-item:hover {
        border-color: #732370;
    }

    .tab-item p {
        text-decoration: none;
        color: #713E5A;
        font-size: 2rem;
        font-weight: bolder;
        display: inline;
    }


</style>
