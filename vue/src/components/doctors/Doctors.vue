<template>
    <div>
        <div class="wrapper">
            <h1>Find your specialist</h1>
            <div class="search-toolbar">
                <select id="specialist-select" v-model="selectedSpecialisation">
                    <option value="">Specialisation</option>
                    <option value="cornea-and-external-disease">Cornea and External Disease</option>
                    <option value="ophthalmic-pathology">Ophthalmic Pathology</option>
                </select>

                <select id="clinic-select" v-model="selectedClinic">
                    <option value="">Choose...</option>
                    <option value="warszawa-puławska-427">Warszawa, Puławska 427</option>
                    <option value="warszawa-krakowiaków-11">Warszawa, Krakowiaków 11</option>
                </select>

                <button>Search</button>
            </div>

            <div class="specialists-list" v-if="isFiltered">

                <div :key="specialist.id" v-for="specialist in specialists">


                    <div class="specialist-detail">

                        <div class="header">
                            <h1> {{specialist.firstName}} {{specialist.lastName}}</h1>
                            <h2>{{specialist.specialisation}}</h2>
                            <h4>Rating: {{specialist.rating}}</h4>

                        </div>


                        <h4>{{specialist.description}}</h4>

                        <button>Make an appointment</button>

                    </div>

                    <br>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    /* eslint-disable */


    export default {
        name: "Doctors",
        data() {
            return {
                specialists: [],
                selectedSpecialisation: '',
                selectedClinic: '',
                isFiltered: false
            }
        },
        mounted() {
            this.getDoctors();
        },

        methods: {

            matchingDoctors() {

                this.isFiltered = true;
                return this.specialists.filter(doc => doc.specialisation === this.selectedSpecialisation);

            }
            ,

            async getDoctors() {
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/specialists"
                    );
                    const data = await response.json();
                    this.specialists = data;
                    this.isFiltered = true;

                } catch (error) {
                    // eslint-disable-next-line no-console
                    console.error(error);
                }
                // eslint-disable-next-line no-console
            }
        }
    }
</script>

<style scoped>
    .wrapper {
        padding: 1rem 2rem;
        margin: 10px 20px;
        text-align: center;
    }

    .search-toolbar {
        display: flex;
        justify-content: space-evenly;
    }

    select {
        width: 50%;
        height: 4rem;
        margin: 3rem;
    }

    button {
        height: 4rem;
        align-self: center;
    }

    .specialist-detail {
        border: 2px solid black;
    }

    .header {
        display: flex;
        justify-content: space-around;
        align-content: center;
        border-bottom: 1px solid #9bafa7;
    }
</style>
