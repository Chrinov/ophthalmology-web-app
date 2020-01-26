<template>
    <div>

        <!--        <div class="search-container">-->
        <!--            <form>-->
        <!--                <input type="text" placeholder="Search.." name="search">-->
        <!--                <button type="submit">Search</button>-->
        <!--            </form>-->
        <!--        </div>-->


        <br>

        <hr>

        <ul class="wrapper">

            <table v-if="isDataLoaded">

                <tr>
                    <th>PESEL</th>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Surname</th>
                    <th>Phone Number</th>
                    <th></th>
                </tr>


                <tr :key="patient.id" v-for="patient in this.patients">

                    <td>{{patient.pesel}}</td>
                    <td>{{patient.email}}</td>
                    <td>{{patient.firstName}}</td>
                    <td>{{patient.lastName}}</td>
                    <td>{{patient.phoneNumber}}</td>

                    <td>
                        <button @click="preparePatientDetail(patient)">Show details</button>
                    </td>

                </tr>


            </table>

        </ul>
        <PatientEdit :patientData="this.currentPatient" @close="refreshTable" v-if="isPatientDetail"/>

    </div>
</template>

<script>
    /* eslint-disable */

    import PatientEdit from "@/components/adminPortal/PatientEdit";

    export default {
        name: "PatientGrid",
        components: {PatientEdit},
        data() {
            return {
                isPatientDetail: false,
                patients: [],
                currentPatient: null,
                isDataLoaded: false

            }
        },
        mounted() {
            this.getPatients();
        },
        methods: {
            refreshTable() {
                this.isPatientDetail = false;
                this.getPatients();
            },
            async getPatients() {
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/patients"
                    );
                    const data = await response.json();
                    this.patients = data;
                    this.isDataLoaded = true;
                } catch (error) {
                    // eslint-disable-next-line no-console
                    console.error(error);
                }
                // eslint-disable-next-line no-console
            }
            ,
            preparePatientDetail(patient) {
                this.currentPatient = patient;
                this.isPatientDetail = true;

            }
        }
    }
</script>

<style scoped>


    ul {
        list-style-type: none;
    }

    table {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        border: 1px solid #ddd;
    }

    td {
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(odd) {
        background-color: #f2f2f2;
    }


    .search-container {
        float: left;
        border: none;
        font-size: 17px;
    }
</style>
