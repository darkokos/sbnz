"use client";

import { IconButton } from "@mui/material";
import { closeSnackbar, SnackbarProvider } from "notistack";
import CloseIcon from "@mui/icons-material/Close";

export default function NotistackProvider({
  autoHideDuration,
  anchorOrigin,
  children,
}: React.ComponentPropsWithoutRef<typeof SnackbarProvider>) {
  return (
    <SnackbarProvider
      autoHideDuration={autoHideDuration}
      anchorOrigin={anchorOrigin}
      action={(snackbarKey) => (
        <IconButton onClick={() => closeSnackbar(snackbarKey)}>
          <CloseIcon style={{ color: "white" }} />
        </IconButton>
      )}
    >
      {children}
    </SnackbarProvider>
  );
}
