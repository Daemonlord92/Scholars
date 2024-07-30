import { useMutation } from "@tanstack/react-query"
import axios from "axios"
import { useFormik } from "formik"
import { useNavigate } from "react-router-dom"

import * as Yup from 'yup'

const Login = () => {
    const navigate = useNavigate();
    const LoginSchema = Yup.object({
        username: Yup.string()
        .required("Required"),
        password: Yup.string()
        .required("Required")
    })

    const postLogin = async (values:any) => {
        const request = await axios.post(import.meta.env.VITE_API_URL + "/auth/login", values)
        const response = await request;
        return response.data;
    }

    const mutation = useMutation({
        mutationFn: postLogin,
        onSuccess: (data) => {
            sessionStorage.setItem("Authorization", data)
            alert("Login Successful")
            window.dispatchEvent(new Event('authChange'));
            navigate("/cars")
        },
        onError: (error) => {
            alert("Login Unsucessful")
        }
    })

    const formik = useFormik({
        initialValues: {
            username: '',
            password: ''
        },
        validationSchema: LoginSchema,
        onSubmit: (values) => mutation.mutate(values)
    })
    return (
        <div>
            <h1>Log in</h1>
            <div>
                <form onSubmit={formik.handleSubmit}>
                    <label htmlFor="username">Username:</label>
                    <input type="text" id="username" value={formik.values.username} onChange={formik.handleChange} />
                    <label htmlFor="password">Password:</label>
                    <input type="text" id="password" value={formik.values.password} onChange={formik.handleChange} />
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    )
}

export default Login