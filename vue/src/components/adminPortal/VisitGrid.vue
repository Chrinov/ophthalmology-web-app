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
                    <th>Data</th>
                    <th>Email</th>
                    <th>Last name</th>
                    <th>Doctor</th>
                    <th>Address</th>
                    <th></th>
                </tr>


                <tr :key="visit.id" v-for="visit in this.visits">

                    <!--                    <td>{{visit.day}}/{{visit.month}}/{{visit.year}} {{visit.hour}}:{{visit.minutes}}</td>-->
                    <td>{{visit.date}}</td>
                    <td>{{visit.patient.email}}</td>
                    <td>{{visit.patient.lastName}}</td>
                    <td>{{visit.doctor.lastName}}</td>
                    <td>{{visit.clinic}}</td>

                    <td>
                        <button @click="prepareVisitDetail(visit)">Show details</button>
                    </td>

                </tr>


            </table>

        </ul>
        <VisitEdit :visitData="this.currentVisit" @close="refreshTable" v-if="isVisitDetail"/>

    </div>
</template>

<script>
    /* eslint-disable */

    import VisitEdit from "@/components/adminPortal/VisitEdit";

    export default {
        name: "VisitGrid",
        components: {VisitEdit},
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
            refreshTable() {
                this.isVisitDetail = false;
                this.getVisits();
            },
            async getVisits() {
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/visits"
                    );
                    const data = await response.json();
                    this.visits = data;
                    this.isDataLoaded = true;

                } catch (error) {
                    console.error(error);
                }
            }
            ,
            prepareVisitDetail(visit) {
                this.currentVisit = visit;
                this.isVisitDetail = true;

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
