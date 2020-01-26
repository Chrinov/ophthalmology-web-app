<template>
    <div class="home-container">

        <section class="hero">
            <img alt="Eyes image" src="../assets/eyes.png">

            <div class="hero-button">
                <a @click="showForm = true" class="button">Make an appointment</a>
            </div>


        </section>

        <SignForm @close="showForm = false" v-if="showForm"/>

        <section class="content">
            <p class="title">Our mission</p>


            <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda nostrum saepe sit. Laboriosam
                maxime nisi odit quae quis saepe tenetur voluptates. A adipisci assumenda debitis enim fuga, obcaecati
                pariatur voluptates!
            </div>
            <br/>
            <div>Accusantium alias animi autem culpa deleniti distinctio ea eos facilis illo impedit iste iure iusto
                mollitia natus neque nesciunt possimus repudiandae saepe, sequi tenetur totam veritatis voluptate
                voluptatem? Libero, soluta!
            </div>

        </section>

        <router-link to="/adminportal" v-if="isAdmin">Admin portal</router-link>

    </div>
</template>

<script>
    import {userId} from "@/repository";
    import SignForm from "@/components/signForms/SignForm";

    export default {

        name: "Home",
        components: {SignForm},
        data() {
            return {
                showForm: false
            }
        },
        methods: {
            isAdmin() {
                return userId === 4;
            }
        }

    }
</script>

<style scoped>

    .hero {
        display: block;
        position: relative;
        width: 100%;
    }

    .hero img {
        width: 100%;
        height: auto;
        background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5));
    }

    .hero .hero-button {
        position: absolute;
        top: 25%;
        left: 50%;
        transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
        background-color: #6078ea;
        color: white;
        font-size: 1.5em;
        padding: 1em 3em;
        border: none;
        border-radius: 10px;
        text-align: center;
    }

    .hero a {
        text-decoration: none;
        color: white;
    }

    .hero a:hover {
        color: white;
    }

    .hero .hero-button:hover {
        box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
    }

    .content {
        display: flex;
        flex-direction: column;
        padding: 20px;
    }

    .content .title {
        font-size: 3em;
        font-weight: bolder;
        text-align: center;
    }

    .content div {
        font-size: 1.5em;
        text-align: justify-all;
    }

    @media all and (max-width: 900px) {
        .hero {
            display: none;
        }


    }
</style>
