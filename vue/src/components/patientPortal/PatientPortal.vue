<template>
    <div>
        <div class="user-panel-column-layout">

            <div class="tab-column">

                <ul class="tab-items">
                    <li @click="showStart" class="tab-item"><p>start</p></li>
                    <li @click="showVisits" class="tab-item"><p>visits</p></li>
                    <li class="tab-item"><p>prescription</p></li>
                    <li class="tab-item"><p>results</p></li>
                    <li @click="showUserData" class="tab-item"><p>data</p></li>
                    <li class="tab-item"><p>settings</p></li>
                </ul>

            </div>

            <div class="appointment-column">

                <AppointmentForm v-if="isStart"/>

                <Visits v-if="isVisitsHistory"/>

                <PatientData v-if="isUserData"/>
            </div>

        </div>
    </div>
</template>

<script>
    import AppointmentForm from "@/components/patientPortal/AppointmentForm";
    import Visits from "@/components/patientPortal/visits/Visits";
    import PatientData from "@/components/patientPortal/PatientData";


    export default {

        data() {
            return {
                isStart: true,
                isVisitsHistory: false,
                isUserData: false
            }

        },
        name: "PatientPortal",
        components: {PatientData, Visits, AppointmentForm},
        methods: {
            showVisits() {
                this.isStart = false;
                this.isVisitsHistory = true;
                this.isUserData = false;

            },
            showStart() {
                this.isStart = true;
                this.isVisitsHistory = false;
                this.isUserData = false;
            },
            showUserData() {
                this.isStart = false;
                this.isVisitsHistory = false;
                this.isUserData = true;
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
        flex: 1;
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
