import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home.vue'
import Signup from '@/components/signForms/SignForm.vue'
import PatientPortal from "@/components/patientPortal/PatientPortal.vue";
import Patients from "@/components/patientPortal/Patients.vue";
import Doctors from "@/components/doctors/Doctors.vue"
import AdminPortal from "@/components/adminPortal/AdminPortal";

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/signup',
        name: 'signup',
        component: Signup
    },
    {
        path: '/patientportal',
        name: 'patientportal',
        component: PatientPortal
    },
    {
        path: '/adminportal',
        name: 'adminportal',
        component: AdminPortal
    },
    {
        path: "/patients",
        name: 'patients',
        component: Patients
    },
    {
        path: "/doctors",
        name: 'doctors',
        component: Doctors
    }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router
