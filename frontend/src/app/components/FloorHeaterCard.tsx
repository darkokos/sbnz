import { Dispatch, SetStateAction } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";

export default function FloorHeaterCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Floor Heater" onSubmit={onSubmit}>
      asd
    </HomeStateCardTemplate>
  );
}
