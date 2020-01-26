<template>
    <div id="patients">


        <h1>Patients:</h1>


        <div :key="patient.id" v-for="patient in patients">
            {{patient.firstName}}
            {{patient.lastName}}
            <br>
        </div>

    </div>
</template>

<script>
    export default {

        name: "Patients",
        components: {},
        data() {
            return {
                patients: []
            }
        },
        mounted() {
            this.getPatients();
        },
        methods: {
            async getPatients() {
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/patients"
                    );
                    const data = await response.json();
                    this.patients = data;
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

</style>
