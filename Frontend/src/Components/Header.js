import React, { Component } from "react"
import "../Style/Header.css"

class Header extends Component {
    render() {
        return (
            <header className="header">
                <h1 className="title">Calculator</h1>
            </header>
        )
    }
}

export default Header;