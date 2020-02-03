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
                    <th>Last Name</th>
                    <th>Specialisation</th>
                    <th></th>
                </tr>


                <tr :key="specialist.id" v-for="specialist in this.specialists">

                    <td>{{specialist.pesel}}</td>
                    <td>{{specialist.email}}</td>
                    <td>{{specialist.firstName}}</td>
                    <td>{{specialist.lastName}}</td>
                    <td>{{specialist.specialisation}}</td>

                    <td>
                        <button @click="prepareDoctorDetail(specialist)">Show details</button>
                    </td>

                </tr>


            </table>

        </ul>


        <DoctorEdit :doctorData="this.currentDoctor" @close="refreshTable" v-if="isDoctorDetail"/>

    </div>
</template>

<script>
    /* eslint-disable */

    import DoctorEdit from "@/components/adminPortal/DoctorEdit";

    export default {
        name: "DoctorGrid",
        components: {DoctorEdit},
        data() {
            return {
                isDoctorDetail: false,
                isNewDoctor: false,
                specialists: [],
                currentDoctor: null,
                isDataLoaded: false

            }
        },
        mounted() {
            this.getDoctors();
        },
        methods: {
            refreshTable() {
                this.isDoctorDetail = false;
                this.getDoctors();
            },

            async getDoctors() {
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/specialists"
                    );
                    const data = await response.json();
                    this.specialists = data;
                    this.isDataLoaded = true;
                } catch (error) {
                    // eslint-disable-next-line no-console
                    console.error(error);
                }
                // eslint-disable-next-line no-console
            }
            ,
            prepareDoctorDetail(specialist) {
                this.currentDoctor = specialist;
                this.isDoctorDetail = true;

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
