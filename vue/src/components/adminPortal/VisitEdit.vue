<template>
    <div>
        <div class="modal" style="display: inline">

            <!-- Modal content -->
            <div class="modal-content">
                <div class="modal-body">


                    <div style="overflow-x:auto;">
                        <table v-if="isDataLoaded">
                            <tr>
                                <td>Date</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="datetime-local" v-model="updatedVisit.date">
                                </td>
                            </tr>
                            <tr>
                                <td>Doctor</td>
                            </tr>
                            <tr>
                                <td>
                                    <!--                                    {{updatedVisit.specialist.title}} {{updatedVisit.specialist.firstName}} {{updatedVisit.specialist.lastName}}-->
                                    <!--                                <br>-->
                                    <select id="specialist-select" name="specialist" v-model="updatedVisit.specialist">
                                        <option value="">Choose...</option>
                                        <option :key="specialist.id" :value="specialist" v-for="specialist in specialists">
                                            {{specialist.firstName}}
                                            {{specialist.lastName}}
                                        </option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Address</td>
                            </tr>

                            <tr>
                                <td>
                                    <!--                                    {{updatedVisit.clinic}}-->
                                    <!--                                    <br>-->
                                    <select id="clinic-select" name="clinic" v-model="updatedVisit.clinic">
                                        <option :selected="updatedVisit.clinic">{{updatedVisit.clinic}}</option>
                                        <option value="Puławska 427">Puławska 427</option>
                                        <option value="Gdynia, Morska 15">Gdynia, Morska 15</option>
                                    </select>

                                </td>
                            </tr>

                            <tr>
                                <td>Visit type</td>
                            </tr>

                            <tr>
                                <td>
                                    <select id="visit-type-select" name="visitType" v-model="updatedVisit.visitType">
                                        <option :selected="updatedVisit.visitType">{{updatedVisit.visitType}}</option>
                                        <option value="pre-surgery visit">Pre-surgery visit</option>
                                        <option value="post-surgery visit">Post-surgery visit</option>
                                        <option value="check-up">Check up</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Reason</td>
                            </tr>

                            <tr>
                                <td>
                                    <textarea cols="100" rows="5" v-model="updatedVisit.reason"></textarea>
                                </td>
                            </tr>

                            <tr>
                                <td>Description</td>
                            </tr>

                            <tr>
                                <td>
                                    <textarea cols="100" rows="5" v-model="updatedVisit.description"></textarea>

                                </td>
                            </tr>


                        </table>
                    </div>


                    <div class="button-row">
                        <button @click="editVisit(updatedVisit.id)">SAVE</button>
                        <button @click="$emit('close')">CANCEL</button>
                        <button @click="deleteVisit(updatedVisit.id)">DELETE VISIT</button>
                    </div>

                </div>
            </div>

        </div>

    </div>
</template>

<script>
    /* eslint-disable */

    export default {
        name: "VisitEdit",
        data() {
            return {
                specialists: [],
                isDataLoaded: false,
                updatedVisit: Object,
                addresses: ['Warszawa, Puławska 427', 'Gdynia, Morska 15'],
                visitTypes: ['Pre-surgery', 'Post-surgery', 'Regular check-up', 'Emergency'],
                isSubmitted: false,

            }
        },
        props: {
            visitData: Object
        },
        mounted() {
            // eslint-disable-next-line
            this.updatedVisit = this.visitData;
            this.isDataLoaded = true;
            this.getDoctors();
        },
        methods: {
            submitted() {
                this.submitted = true;
            },
            async getDoctors() {
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/specialists"
                    );
                    const data = await response.json();
                    this.specialists = data;

                } catch (error) {
                    console.error(error);
                }
            },
            async deleteVisit(id) {
                try {
                    await fetch(`http://localhost:5000/api/visits/${id}`, {
                        method: "DELETE"
                    });
                } catch (error) {
                    console.error(error);
                }
                this.$emit('close');
            },
            async editVisit(id) {


                // let d = new Date(this.updatedVisit.date);
                // this.updatedVisit.day = d.getUTCDate();
                // this.updatedVisit.month = d.getUTCMonth();
                // this.updatedVisit.year = d.getFullYear();
                // this.updatedVisit.hour = d.getUTCHours();
                // this.updatedVisit.minutes = d.getUTCMinutes();
                try {
                    await fetch(`http://localhost:5000/api/visits/${id}`, {
                        method: 'PUT',
                        body: JSON.stringify(this.updatedVisit),
                        headers: {'Content-type': 'application/json; charset=UTF-8'},
                    });

                    alert('successfully edited visit');
                } catch (error) {
                    console.error(error)
                }
            }
        }
    }
</script>

<style scoped>
    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        padding-top: 100px;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgb(0, 0, 0);
        background-color: rgba(0, 0, 0, 0.4);
    }


    /* Modal Content */

    .modal-content {
        position: relative;
        background-color: #fefefe;
        margin: auto;
        padding: 0;
        border: 1px solid #888;
        width: 80%;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -webkit-animation-name: animatetop;
        -webkit-animation-duration: 0.4s;
        animation-name: animatetop;
        animation-duration: 0.4s
    }

    .close {
        color: white;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        cursor: pointer;
    }

    .close a {
        text-decoration: none;

    }


    .modal-body {
        padding: 2px 16px;
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
        font-weight: bolder;
    }

    .button-row {
        padding: 10px;
        display: flex;
        justify-content: space-around;
    }

</style>
