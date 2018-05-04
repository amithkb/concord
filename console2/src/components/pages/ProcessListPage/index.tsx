import * as React from 'react';
import { Breadcrumb } from 'semantic-ui-react';

import { BreadcrumbSegment } from '../../molecules';
import { ProcessList } from '../../organisms';

export default class extends React.PureComponent {
    render() {
        return (
            <>
                <BreadcrumbSegment>
                    <Breadcrumb.Section active={true}>Processes</Breadcrumb.Section>
                </BreadcrumbSegment>

                <ProcessList />
            </>
        );
    }
}
