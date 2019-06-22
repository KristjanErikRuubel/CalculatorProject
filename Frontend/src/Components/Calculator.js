import React, { Component, Fragment } from "react";
import Header from "../Components/Header";
import Collapse from "../Components/Collapse";
import Form from "../Components/Form";
import "../Style/Calculator.css";


class Calculator extends Component {
    render() {
        return (
            <div className="container">
                <Fragment>
                    <Header />
                    <Form />
                    <Collapse/>
                </Fragment>
            </div>
        )
    }
}
export default Calculator;