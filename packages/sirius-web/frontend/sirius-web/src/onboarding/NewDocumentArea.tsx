/*******************************************************************************
 * Copyright (c) 2019, 2023 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
import { gql, useMutation } from '@apollo/client';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import IconButton from '@material-ui/core/IconButton';
import List from '@material-ui/core/List/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import Snackbar from '@material-ui/core/Snackbar';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import { Close as CloseIcon, NoteAdd } from '@material-ui/icons';
import { useEffect, useState } from 'react';
import { v4 as uuid } from 'uuid';
import {
  GQLCreateDocumentMutationInput,
  GQLCreateDocumentMutationVariables,
  GQLInvokeEditingContextActionInput,
  GQLInvokeEditingContextActionVariables,
  NewDocumentAreaProps,
  NewDocumentAreaState,
} from './NewDocumentArea.types';

const useNewDocumentAreaStyles = makeStyles((theme) => ({
  cardContent: {
    overflowY: 'auto',
    maxHeight: theme.spacing(50),
  },
  item: {
    padding: 0,
  },
}));

const createDocumentMutation = gql`
  mutation createDocument($input: CreateDocumentInput!) {
    createDocument(input: $input) {
      __typename
      ... on ErrorPayload {
        message
      }
    }
  }
`;

const invokeEditingContextActionMutation = gql`
  mutation invokeEditingContextAction($input: InvokeEditingContextActionInput!) {
    invokeEditingContextAction(input: $input) {
      __typename
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const NewDocumentArea = ({
  editingContextId,
  stereotypeDescriptions,
  editingContextActions,
  readOnly,
}: NewDocumentAreaProps) => {
  const classes = useNewDocumentAreaStyles();
  const [state, setState] = useState<NewDocumentAreaState>({
    message: null,
  });

  // Document creation
  const [createDocument, { loading, data, error }] = useMutation(createDocumentMutation);
  const onCreateDocument = (stereotypeDescriptionId: string) => {
    const selected = stereotypeDescriptions.find((candidate) => candidate.id === stereotypeDescriptionId);
    const input: GQLCreateDocumentMutationInput = {
      id: uuid(),
      editingContextId,
      name: selected.documentName,
      stereotypeDescriptionId,
    };
    const variables: GQLCreateDocumentMutationVariables = {
      input,
    };
    createDocument({ variables });
  };

  useEffect(() => {
    if (!loading) {
      if (error) {
        setState({ message: 'An unexpected error has occurred, please refresh the page' });
      }
      if (data) {
        const { createDocument } = data;
        if (createDocument.__typename === 'ErrorPayload') {
          setState({ message: createDocument.message });
        }
      }
    }
  }, [loading, error, data]);

  // EditingContext Action invocation
  const [
    invokeEditingContextAction,
    { loading: loadingEditingContextAction, data: dataEditingContextAction, error: errorEditingContextAction },
  ] = useMutation(invokeEditingContextActionMutation);

  const onInvokeEditingContextAction = (actionId: string) => {
    const input: GQLInvokeEditingContextActionInput = {
      id: uuid(),
      editingContextId,
      actionId,
    };
    const variables: GQLInvokeEditingContextActionVariables = {
      input,
    };
    invokeEditingContextAction({ variables });
  };

  useEffect(() => {
    if (!loadingEditingContextAction) {
      if (errorEditingContextAction) {
        setState({ message: 'An unexpected error has occurred, please refresh the page' });
      }
      if (dataEditingContextAction) {
        const { invokeEditingContextAction } = dataEditingContextAction;
        if (invokeEditingContextAction.__typename === 'ErrorPayload') {
          setState({ message: invokeEditingContextAction.message });
        }
      }
    }
  }, [loadingEditingContextAction, errorEditingContextAction, dataEditingContextAction]);

  return (
    <>
      <Card>
        <CardContent className={classes.cardContent}>
          <Typography variant="h6">{'Create a new Model'}</Typography>
          <Typography color="textSecondary">
            {readOnly ? 'You need edit access to create models' : 'Select the model to create'}
          </Typography>
          <List dense={true}>
            {readOnly
              ? null
              : stereotypeDescriptions.map((stereotypeDescription) => {
                  return (
                    <ListItem
                      className={classes.item}
                      disableGutters
                      button
                      key={stereotypeDescription.id}
                      data-testid={stereotypeDescription.id}
                      onClick={() => {
                        onCreateDocument(stereotypeDescription.id);
                      }}>
                      <ListItemIcon>
                        <NoteAdd htmlColor="primary" fontSize="small" />
                      </ListItemIcon>
                      <ListItemText primary={stereotypeDescription.label} />
                    </ListItem>
                  );
                })}
            {readOnly
              ? null
              : editingContextActions.map((editingContextAction) => {
                  return (
                    <ListItem
                      className={classes.item}
                      disableGutters
                      button
                      key={editingContextAction.id}
                      data-testid={editingContextAction.id}
                      onClick={() => {
                        onInvokeEditingContextAction(editingContextAction.id);
                      }}>
                      <ListItemIcon>
                        <NoteAdd htmlColor="primary" fontSize="small" />
                      </ListItemIcon>
                      <ListItemText primary={editingContextAction.label} />
                    </ListItem>
                  );
                })}
          </List>
        </CardContent>
      </Card>
      <Snackbar
        anchorOrigin={{
          vertical: 'bottom',
          horizontal: 'right',
        }}
        open={state.message != null}
        autoHideDuration={3000}
        message={state.message}
        onClose={() => setState({ message: null })}
        action={
          <IconButton size="small" aria-label="close" color="inherit" onClick={() => setState({ message: null })}>
            <CloseIcon fontSize="small" />
          </IconButton>
        }
        data-testid="error"
      />
    </>
  );
};