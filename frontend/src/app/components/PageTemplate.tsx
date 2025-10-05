import { Divider, Stack, Typography } from "@mui/material";
import { ReactNode } from "react";

export default function PageTemplate({
  title,
  children,
}: {
  title: string;
  children: ReactNode;
}) {
  return (
    <Stack gap={2}>
      <div>
        <Typography variant="h3">{title}</Typography>
        <Divider />
      </div>
      {children}
    </Stack>
  );
}
