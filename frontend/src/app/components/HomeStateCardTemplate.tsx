import {
  Button,
  Card,
  CardActions,
  CardContent,
  CardHeader,
} from "@mui/material";
import { MouseEventHandler, ReactNode } from "react";

export default function HomeStateCardTemplate({
  title,
  onSubmit,
  children,
}: {
  title: string;
  onSubmit: MouseEventHandler<HTMLButtonElement>;
  children: ReactNode;
}) {
  return (
    <Card>
      <CardHeader title={title} />
      <CardContent>{children}</CardContent>
      <CardActions style={{ justifyContent: "end" }}>
        <Button variant="contained" onClick={onSubmit}>
          Submit
        </Button>
      </CardActions>
    </Card>
  );
}
