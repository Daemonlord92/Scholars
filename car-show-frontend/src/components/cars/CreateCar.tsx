import { useMutation, useQueryClient } from "@tanstack/react-query";
import { useFormik } from "formik";
import * as Yup from 'yup';
import Car from "../../type/Car";
import axios from "axios";

const CreateCar = ({isOpen, onClose}: {isOpen:boolean, onClose:()=>void}) => {
    const CarSchema = Yup.object({
        make: Yup.string()
        .min(1, "Too Short!")
        .max(25, "Too Long!")
        .required('Required to have a make!'),
        model: Yup.string()
        .min(1, "Too Short!")
        .max(25, "Too Long!")
        .required("Required"),
        price: Yup.number()
        .min(15000.00, "Car too cheap")
        .required("Required"),
        year: Yup.number()
        .min(1886, "Cars didn't exist before then")
        .max(new Date().getFullYear(), "No Time Traveller")
        .required("Required"),
        color: Yup.string()
        .min(3, "There is no color below three characters")
        .required("Required")
    })
    const queryClient = useQueryClient();

    const mutation = useMutation({
        mutationFn: async (newCar:any): Promise<Car> => {
            const {data} = await axios.post(import.meta.env.VITE_API_URL + "/car/", newCar, {
                headers: {
                    "Content-Type": "application/json"
                }
            })
            return data
        },
        onSuccess: () => {
            alert("Car has been added")
            queryClient.invalidateQueries(['cars'])
            onClose()
        },
        onError: (error: Error) => {
            alert(`Error: ${error.message}`)
        }
    })

    const formik = useFormik({
        initialValues:{
            make: '',
            model: '',
            price: 0,
            year: 0,
            color: ''
        },
        validationSchema: CarSchema,
        onSubmit: (values) => {
            mutation.mutate(values)
            
        }
    })
    if(!isOpen) return null;

    return(
        <div className="fixed inset-0 bg-gray-600 bg-opacity-50 flex items-center justify-center">
            <div className="bg-white p-10 m-5 rounded-lg shadow-md w-2/4">
                <div className="flex flex-row justify-end">
                    <button onClick={onClose}>X</button>
                </div>
                <div className="flex justify-end">
                    <form onSubmit={formik.handleSubmit} method="post" className="flex-row w-full">
                        <label htmlFor="make">Make:</label>
                        <input 
                        type="text"
                        id="make" 
                        onChange={formik.handleChange}
                        value={formik.values.make}
                        onBlur={formik.handleBlur}
                        className="mt-1 w-full border border-gray-300 rounded-sm shadow-sm p-2"
                        />
                        {formik.touched.make && formik.errors.make ? (
                            <div className="text-red-500 text-sm">{formik.errors.make}</div>
                        ): null}
                        <label htmlFor="model">Model:</label>
                        <input
                        type="text"
                        id="model"
                        onChange={formik.handleChange}
                        value={formik.values.model}
                        onBlur={formik.handleBlur}
                        className="mt-1 w-full border border-gray-300 rounded-sm shadow-sm p-2" />
                        {formik.touched.model && formik.errors.model ? (
                            <div className="text-red-500 text-sm">{formik.errors.model}</div>
                        ): null}
                        <label htmlFor="price">Price:</label>
                        <input
                        type="number"
                        id="price"
                        onChange={formik.handleChange}
                        value={formik.values.price}
                        onBlur={formik.handleBlur}
                        className="mt-1 w-full border border-gray-300 rounded-sm shadow-sm p-2" />
                        {formik.touched.price && formik.errors.price ? (
                            <div className="text-red-500 text-sm">{formik.errors.price}</div>
                        ): null}
                        <label htmlFor="year">Year:</label>
                        <input
                        type="number"
                        id="year"
                        onChange={formik.handleChange}
                        value={formik.values.year}
                        onBlur={formik.handleBlur}
                        className="mt-1 w-full border border-gray-300 rounded-sm shadow-sm p-2" />
                        {formik.touched.year && formik.errors.year ? (
                            <div className="text-red-500 text-sm">{formik.errors.year}</div>
                        ): null}
                        <label htmlFor="color">Color:</label>
                        <input
                        type="text"
                        id="color"
                        onChange={formik.handleChange}
                        value={formik.values.color}
                        onBlur={formik.handleBlur}
                        className="mt-1 w-full border border-gray-300 rounded-sm shadow-sm p-2" />
                        {formik.touched.color && formik.errors.color ? (
                            <div className="text-red-500 text-sm">{formik.errors.color}</div>
                        ): null}
                        <input type="submit" value="Submit Car" className="border-2 p-1 mt-5 border-teal-500 border-solid rounded-lg bg-slate-400 hover:bg-slate-600 hover:text-white" />
                    </form> 
                </div>
            </div>
        </div>
    )

}

export default CreateCar;