import React from 'react'
import { Link } from "react-router-dom";
export default function Navbar() {
  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <a className="navbar-brand" fontWeight="bold" href="#">
            Academic ERP
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>

          <Link className="ms-auto btn btn-outline-light " to="/home">
            Home
          </Link>
          <Link type="submit" className="btn btn-danger mx-2 " to="/">
                Sign Out
            </Link>
        </div>
      </nav>
    </div>
  )
}

