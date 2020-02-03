<template>
    <div>

        <h1>Your visits</h1>
        <hr>

        <div v-if="isDataLoaded">
            <ul :key="visit.id" class="wrapper" v-for="visit in this.visits">

                <li class="visit-info-row">
                    <!--                    <label>{{visit.date.getUTCDate()}}/{{visit.date.getUTCMonth()}}/{{visit.date.getFullYear()}} {{visit.date.getUTCHours()}}:{{visit.date.getUTCMinutes()}}</label>-->
                    <label>{{visit.date}}</label>

                    <div class="visit-info">
                        <label class="specialist">
                            {{visit.specialist.title}} {{visit.specialist.firstName}} {{visit.specialist.lastName}}
                        </label>
                        <br>
                        <label class="address">
                            Opticus {{visit.clinic}}
                        </label>
                        <br>
                        <label class="visit-type">
                            {{visit.visitType}}
                        </label>

                        <label class="isplanned" v-if="visit.isPlanned">
                            <h4>PLANNED APPOINTMENT</h4>

                            <br>

                            <button @click="deleteVisit(visit.id)" class="cancelbtn">CANCEL</button>

                        </label>

                    </div>

                    <button @click="prepareVisitDetail(visit)">Show</button>
                </li>
            </ul>
            <VisitDetail :visitData="this.currentVisit" @close="isVisitDetail=false" v-if="isVisitDetail"/>

        </div>
    </div>
</template>

<script>
    /* eslint-disable */

    import VisitDetail from "@/components/patientPortal/visits/VisitDetail";
    import {userId} from "@/repository";

    export default {
        name: "Visits",
        components: {VisitDetail},
        data() {
            return {
                isVisitDetail: false,
                visits: [],
                currentVisit: null,
                isDataLoaded: false
            }
        },
        mounted() {
            this.getVisits();
        },
        methods: {

            async deleteVisit(id) {
                try {
                    await fetch(`http://localhost:5000/api/visits/${id}`, {
                        method: "DELETE"
                    });
                    this.visits = this.visits.filter(visit => visit.id !== id);
                } catch (error) {
                    console.error(error);
                }
            },
            async getVisits() {

                console.log(this.visit);
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/visits"
                    );
                    const data = await response.json();
                    this.visits = data.filter(n => n.patient.id === userId);
                    this.isDataLoaded = true;

                } catch (error) {
                    console.error(error);
                }

            },
            prepareVisitDetail(visit) {
                this.currentVisit = visit;
                this.isVisitDetail = true;

            }
        }
    }
</script>

<style scoped>

    .visit-info-row {
        display: flex;
        justify-content: center;
        padding: 0.5rem;
        flex-wrap: wrap;
        border: 2px solid gainsboro;
    }

    .visit-info-row label {
        flex: 1;
    }

    .isplanned {
        color: darkolivegreen;
    }

    .visit-info-row .visit-info {
        flex: 3;
    }

    button {
        background-color: white;
        padding: 14px 28px;
        font-size: 16px;
        cursor: pointer;
        border: 2px solid #2196F3;
        color: dodgerblue;
        border-radius: 5px;
    }

    button:hover {
        background: #2196F3;
        color: white;
    }

    .cancelbtn {
        background-color: palevioletred;
        color: black;
    }
</style>
