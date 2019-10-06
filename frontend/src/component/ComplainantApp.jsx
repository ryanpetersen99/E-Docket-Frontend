import React, { Component } from 'react';
import ListComplainantComponent from './component/ListComplainantComponent';
class ComplainantApp extends Component {
    render() {
        return (<>
              <p>E-docket Application</p>
              <ListComplainantComponent/>
              </>
        )
    }
}

export default ComplainantApp