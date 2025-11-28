import React, { useState } from 'react'
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import Navbar from '../layout/Navbar';
export default function AddDomain() {

    let navigate = useNavigate()
    const [user, setUser] = useState(
        {
            program: "",
            batch: "",
            capacity: "",
            qualification: ""
        }
    )
    const { program, batch, capacity, qualification } = user

    const onInputChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });

    };

    const onSubmit = async (e) => {
        e.preventDefault();
        console.log(user.data);
        //await axios.post("http://localhost:8080/api/v1/domain/createdomain", user);
        const response = await axios.post("http://localhost:8080/api/v1/domain/createdomain", user, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem("jwt")}`,
                Accept: 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
            },
        });

        navigate("/home");
    };

    return (
        <div><Navbar />
            <div className="container">
                <div className="row">
                    <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                        <h3 className='text-center m-4'>Add New Domain</h3>
                        <form onSubmit={(e) => onSubmit(e)}>
                            <div className='mb-3'>
                                <label htmlFor='Name' className='form-label'>
                                    Program Name
                                </label>
                                <input type={"text"} className="form-control" placeholder="Enter Program Name" name="program" value={program} onChange={(e) => onInputChange(e)} />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='Name' className='form-label'>
                                    Batch
                                </label>
                                <input type={"number"} className="form-control" placeholder="Enter Program Batch" name="batch" min="2019" max="2100" value={batch} onChange={(e) => onInputChange(e)} />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='Name' className='form-label'>
                                    Capacity
                                </label>
                                <input type={"number"} className="form-control" placeholder="Enter Program Capacity" name="capacity" value={capacity} onChange={(e) => onInputChange(e)} />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='Name' className='form-label'>
                                    Qualification
                                </label>
                                <input type={"text"} className="form-control" placeholder="Enter required Qualifications" name="qualification" value={qualification} onChange={(e) => onInputChange(e)} />
                            </div>
                            <button type="submit" className="btn btn-outline-primary">
                                Submit
                            </button>
                            <Link type="submit" className="btn btn-outline-danger mx-2 " to="/home">
                                Cancel
                            </Link>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}
