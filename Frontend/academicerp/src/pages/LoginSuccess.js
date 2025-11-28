import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const LoginSuccess = () => {
    const navigate = useNavigate();

    useEffect(() => {
        // The backend redirects here after a successful Google login.
        // The session is already established by the browser's cookie.
        // We can now redirect to the home page.
        navigate('/home');
    }, [navigate]);

    return (
        <div>
            <p>Login successful! Redirecting...</p>
        </div>
    );
};

export default LoginSuccess;
